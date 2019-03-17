
<!DOCTYPE HTML>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

    <title>Task Manager | Home</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="static/js/html5shiv.min.js"></script>
    <script src="static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div role="navigation">
    <div class="navbar navbar-inverse">
        <a href="/" class="navbar-brand">HOME</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">


                <li> <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li><a href="new-job">New Job</a></li>
                </c:if> </li>
                <c:url value="/logout" var="logoutUrl" />

                <li> <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <a href="javascript:document.getElementById('logout').submit()">Logout</a>
                </c:if> </li>

                <c:url value="/login" var="loginUrl" />

                <li> <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <a href="/login">LOGIN</a>
                </c:if> </li>

            </ul>
            <form id="logout" action="${logoutUrl}" method="post" >
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>

    </div>
</div>
<c:choose>
    <c:when test="${mode=='MODE_HOME'}">

        <div class="container" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>Welcome To Job Listings</h1>
            </div>
        </div>


        <div class="container text-center" id="jobsDiv">
            <h1> Jobs</h1>
        </div>
        <hr>
        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead>

                <tr>
                    <th>ID</th>
                    <th>Description</th>
                    <th>Job Title</th>
                    <th>Last Application Date</th>
                    <th>Number Of People To Hire</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach var="Job" items="${jobs}">
                    <tr>
                        <td>${Job.id}</td>
                        <td>${Job.jobDescription}</td>
                        <td>${Job.jobTitle}</td>
                        <td>${Job.lastApplicationDate}</td>
                        <td>${Job.numberOfPeopleToHire}</td>

                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <td><a href="update-job?id=${Job.id}">UPDATE</a> </td>
                        </c:if>
                        <li> <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <td><a href="see-details?id=${Job.id}">Show Details</a> </td>
                            </c:if>





                    </tr>
                </c:forEach>


                </tbody>


            </table>

        </div>

    </c:when>
    <c:when test="${mode=='MODE_DETAILS'}">

<div class="container text-center"->
    <h3>Job Details </h3>
    <form class="form-horizontal" method="POST" action="save-applicant"/>
    <div class="form-group">
        <label class="control-label col-md-3"> NAME  </label>
        <div class="col-md-7">
            <input type="text" class="form-control" name="name" value="${applicant.name}" />
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-md-3">Email</label>
        <div class="col-md-7">
            <input type="text" class="form-control" name="email" value="${applicant.email}"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-md-3">Phone</label>
        <div class="col-md-7">
            <input type="text" class="form-control" name="phone" value="${applicant.phone}" />
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-md-3">Adress</label>
        <div class="col-md-7">
            <input type="text" class="form-control" name="adress" value="${applicant.adress}"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-md-3">Thoughts On Job</label>
        <div class="col-md-7">
            <input type="text" class="form-control" name="thoughtsOnJob" value="${applicant.thoughtsOnJob}"/>
        </div>
    </div>

    <div class="pull-right">

        <input type="submit" class="btn btn-primary" value="Save"  />

    </div>





</c:when>

    <c:when test="${mode=='MODE_NEW' || mode== 'MODE_UPDATE'}">
        <div class="container text-center"->
            <h3>Job Details </h3>
            <form class="form-horizontal" method="POST" action="save-job"/>

                <input type="hidden" name="id" value="${jobs.id}" />
                <div class="form-group">
                    <label class="control-label col-md-3">Job Description  </label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="jobDescription" value="${jobs.jobDescription}" />
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3">Job Title</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="jobTitle" value="${jobs.jobTitle}"/>
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-md-3">Number Of People To Hire</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="numberOfPeopleToHire" value="${jobs.numberOfPeopleToHire}"/>
                    </div>
                </div>

                <div class="pull-right">

                    <input type="submit" class="btn btn-primary" value="Save"  />
                    
                </div>


            

            </form>



        </div>


    </c:when>




    
</c:choose>








<script src="static/js/jquery-1.11.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>