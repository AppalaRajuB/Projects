<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page isELIgnored="false"%>
<jsp:include page="../pages/homeheader.jsp" />
<head>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>

</head>
<div class="container-fluid">
<div class="card">
	<div class="card-body" >
	<form:form action="./charts" modelAttribute="users" method="get">
		<div class="col-sm-12 dropdown-header" align="right">
            <form:select path = "charttype" onchange="this.form.submit()">
               <form:option value = "daily" label = "Daily"/>
               <form:option value = "monthly" label = "Monthly" />
            </form:select> 
        </div>
      </form:form>            
				 <div id="linechart"></div>
					
		</div>
	</div>
</div>
</div>

<jsp:include page="../pages/homefooter.jsp" />

<script>

Highcharts.chart('linechart', {
	  chart: {
	    type: 'line'
	  },
	  title: {
	    text: 'Customer Graph'
	  },
	  subtitle: {
	    text: ''
	  },
	  xAxis: {
		  
	    categories: ${day}
	  },
	  yAxis: {
	    title: {
	      text: 'No.of Users'
	    }
	  },
	  plotOptions: {
	    line: {
	      dataLabels: {
	        enabled: true
	      },
	      enableMouseTracking: true
	    }
	  },
	  series: [{
	    name: 'Users',
	    data: ${usrs.values()}
	  }]
	});
</script>