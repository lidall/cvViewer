

package com.lida.cvviewermaven;


import java.io.File;
import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import java.io.FileInputStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

public class UploadProcess extends HttpServlet {
    
    //Keep in mind that this file path is for Linux OS
    private String filePath = "/home/ubuntu/uploadfile";
    
    
    private String strParser(String targetStr){
        
      String outputStr = "";
                
      String name = "";
      String phone = "";
      String email = "";
      String title = "";
      String education = "";
      String area = "";
      int lineIndex = 0;
      for(String ele: targetStr.split("\n")){
     if (!ele.replace(" ", "").equals("") && !ele.contains("Page")){
         name = ele;
         break;
     }

    }
      
      String regexPhoneStr = "^[0-9]{9}$";
      
      for(String ele: targetStr.split("\n")){

     if (ele.contains("Phone")){
         if (!ele.split(":")[1].replace(" ", "").equals("")){
             phone = ele.split(":")[1];
         }else{
         phone = targetStr.split("\n")[lineIndex+1];}
     } else if (ele.matches(regexPhoneStr)){
         System.out.println("match: " + ele);
         phone = ele;
     }
     
     if (ele.contains("E-mail")){
         if (!ele.split(":")[1].replace(" ", "").equals("")){
             email = ele.split(":")[1];
         }else{
         email = targetStr.split("\n")[lineIndex+1];}
     } else if (ele.contains("@") && ele.contains(".com")){
         email = ele;
     }
     
     if (ele.contains("Title")){
         if (!ele.split(":")[1].replace(" ", "").equals("")){
             title = ele.split(":")[1];
         }else{
         title = targetStr.split("\n")[lineIndex+1];}
     }
     if (ele.contains("Education")){
         if (!ele.split(":")[1].replace(" ", "").equals("")){
             education = ele.split(":")[1];
         }else{
         education = targetStr.split("\n")[lineIndex+1];}
     }
     if (ele.contains("Area of expertise")){
         if (!ele.split(":")[1].replace(" ", "").equals("")){
             area = ele.split(":")[1].replace(",", "");
         }else{
         area = targetStr.split("\n")[lineIndex+1].replace(",", "");}
     }
     
     lineIndex ++;

    }
    
      lineIndex = 0;
      String computerSkill = "";
      
      for(String ele: targetStr.split("\n")){
          if (ele.contains("COMPUTER SKILLS")){
              int counter = 1;
          
         while (true){
             if (!targetStr.split("\n")[lineIndex + counter].replace(" ", "").equals("")){
                 computerSkill += "- " + targetStr.split("\n")[lineIndex + counter] + "<br>";
         }else{
                 if (!computerSkill.equals("")){
                     break;
                 }
             }
             counter ++;
          }
          
      }
          lineIndex ++;
      }


      outputStr = "Candidate Name: " + name + "<br>Candidate Phone: " + phone + 
              "<br>Candidate Email: " + email + "<br>Application Title: " + title 
              + "<br>Candidate Education: " + education + 
              "<br>Candidate Area of Expertise: " + area + "<br>Candidate Computer Skill:<br>" + computerSkill;
                
        return outputStr;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //..
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String file_path = "";
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem fileItem : multiparts) {
                    if (!fileItem.isFormField()) {
                        String fileName = new File(fileItem.getName()).getName();
                        fileItem.write(new File(filePath + File.separator + fileName));
                        file_path = filePath + File.separator + fileName;
                        request.setAttribute("message", "Your file " + fileName + " upload Successfully ! <br>Items below show your basic Info:");
                    }
                }
                if (file_path.contains("pdf")){
      BodyContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      FileInputStream inputstream = new FileInputStream(new File(
         file_path));
      
      ParseContext pcontext = new ParseContext();

      //parsing the document using PDF parser
      PDFParser pdfparser = new PDFParser();
      pdfparser.parse(inputstream, handler, metadata,pcontext);
      
      request.setAttribute("outstr", strParser(handler.toString()));
      
       
    } else if (file_path.contains("docx")){
     FileInputStream fis = new FileInputStream(file_path);
     XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
     XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);

     
     request.setAttribute("outstr",strParser(extractor.getText()));
      
     
 }
                
                
            }
            catch (Exception x) {
                request.setAttribute("message", "File Upload Failed due to " + x);
            }
        }
        else {
            request.setAttribute("message", "No File found !");
        }
        request.getRequestDispatcher("uploadResult.jsp").forward(request, response);
    }

}
