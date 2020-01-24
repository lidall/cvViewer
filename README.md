# cvViewer

Parse pdf or docx resume and extract basic candidate information.

This repo has been deployed on AWS cloud service and realizing CI/CD.

- buildspec.yml shows how to use AWS codebuild module to automatically build the app (CI)
- appspec.yml and scripts/ folder shows the config how to deploy the web application to AWS EC2 instance (CD)

ScreenShot folder shows a demo of my web app.

<div style="width:450px" align=center><img width="600" height="400" alt="Upload File" src="https://github.com/lidall/cvViewer/blob/master/screenshot/upload_pdf.png"/></div>
<div style="width:450px" align=center><img width="600" height="400" alt="Result" src="https://github.com/lidall/cvViewer/blob/master/screenshot/result_pdf.png"/>
</div>

If you are interested im it, you can click [here](http://ec2-13-53-138-237.eu-north-1.compute.amazonaws.com:8080/) to my site. :)
