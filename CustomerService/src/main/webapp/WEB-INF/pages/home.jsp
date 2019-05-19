<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../pages/homeheader.jsp" />


<head>
<style>
	.jumbotron {
  position: relative;
  overflow: hidden;
  background-color:black;
}
.jumbotron video {
  position: absolute;
  z-index: 1;
  top: 0;
  width:100%;
  height:100%;
  /*  object-fit is not supported on IE  */
  object-fit: cover;
  opacity:0.5;
}
.jumbotron .container {
  z-index: 2;
  position: relative;
}
</style>
</head>

<!--  Body Start-->
 <div class="jumbotron jumbotron-fluid">

<video autoplay muted loop poster="">   
	<source src="" data-src="<%=request.getContextPath()%>/resources/vedios/business.mp4" type="video/mp4">
	<source src="" data-src="<%=request.getContextPath()%>/resources/vedios/graph.mp4" type="video/mp4"> 
    <source src="" data-src="<%=request.getContextPath()%>/resources/vedios/business3.mp4" type="video/mp4">    
    <source src="" data-src="<%=request.getContextPath()%>/resources/vedios/business2.mp4" type="video/mp4">
</video>

  <div class="container text-white">

    <h1 class="display-4">Customer Service</h1>
    <ul>
    <li> <p class="lead">You can view all user details.</p> </li>
    <li><p class="lead">You can view all personal details.</p> </li>
    <li><p class="lead">Edit personal details.</p> </li>
    <li><p class="lead">View graph daily and monthly.</p> </li>
    </ul>
  <!--  <hr class="my-4">
    <p>Learn more about Customer Service by clicking on the below link</p>
    <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
 --> 
  </div>
  <!-- /.container -->
</div>
<!-- /.jumbotron -->

<!-- Body End -->

<jsp:include page="../pages/homefooter.jsp" />


<script>
function deferVideo() {

    //defer html5 video loading
  $("video source").each(function() {
    var sourceFile = $(this).attr("data-src");
    $(this).attr("src", sourceFile);
    var video = this.parentElement;
    video.load();
    // uncomment if video is not autoplay
    //video.play();
  });

}
window.onload = deferVideo;
</script>
