<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻网</title>
<link href="${pageContext.request.contextPath}/style/news.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div class="container">
<jsp:include page="common/head.jsp"/>

<div class="row-fluid">
	<div class="span9">
		<div>
			<DIV style="width: 330px; height: 228px;" class="tuhuo">
				<A href="" target="_blank"><IMG style="width: 330px; height: 208px;" id="fou_img" src=""></A>
					<c:forEach var="isImage" items="${isImageList}">
						<A href="${pageContext.request.contextPath }/news/show/${isImage.newsid }"> 
							<IMG style="display: none;" class="tu_img" src="${pageContext.request.contextPath }/userImage/${isImage.imagename }" width="330" height="208" />
						</A>
					</c:forEach>
					<c:forEach var="isImage" items="${isImageList}">
						<P style="height: 20px;" class="tc"><A href="${pageContext.request.contextPath }/news/show/${isImage.newsid }" target="_blank" title="${isImage.title }">${fn:substring(isImage.title,0,18) }</A></P>
					</c:forEach>

<UL>
  <LI class="fouce">1</LI>
  <LI>2</LI>
  <LI>3</LI>
  <LI>4</LI>
  <LI>5</LI></UL></DIV>
			
		</div>
		<div class="newsHeader_list">
			<div class="newsHeader">
				<h3><a href="${pageContext.request.contextPath }/news/show/${isHead.newsid }" title="${isHead.title} }">${fn:substring(isHead.title,0,10) }</a></h3>
				<p>;　${fn:substring(isHead.content,0,37) }...<a href="${pageContext.request.contextPath }/news/show/${isHead.newsid }" >[查看全文]</a></p>
			</div>
			<div class="currentUpdate">
				<div class="currentUpdateHeader">最近更新</div>
				<div class="currentUpdateDatas">
				<table width="100%">
					<c:forEach var="newest" items="${newestList }" varStatus="statu">
						<c:if test="${statu.index % 2 == 0} ">
							<tr>
						</c:if>
							<td width="50%">
								<a href="${pageContext.request.contextPath }/news/show/${newest.newsid }" title="${newest.title }">${fn:substring(newest.title,0,10) }</a>
							</td>
						<c:if test="${statu.index % 2 == 1 }">
							</tr>
						</c:if>
						<c:if test="${statu.count == fn:length(newestList)  }">
							</tr>
						</c:if>
					</c:forEach>
				</table>
				</div>
			</div>
		</div>
	</div>
	<div class="span3">
		<div class="data_list hotspot_news_list">
			<div class="dataHeader">热点新闻</div>
			<div class="datas">
				<ul>
					<c:forEach var="isHot" items="${isHotList }">
						<li><a href="${pageContext.request.contextPath }/news/show/${isHot.newsid }" title="${isHot.title }">${fn:substring(isHot.title,0,10) }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>

	<c:forEach var="newsType" items="${newsTypeList }" varStatus="statu">
		<c:if test="${statu.index%3==0 }">
			<div class="row-fluid">
		</c:if>
		<div class="span4">
			<div class="data_list news_list" >
				<div class="dataHeader">${newsType.typename }<span class="more"><a href="${pageContext.request.contextPath }/news/list/${newsType.newstypeid}/1">更多...</a></span></div>
					<div class="datas">
						<ul>
							<c:forEach var="news" items="${newsType.news }">
						    	<li><fmt:formatDate pattern="MM-dd" value="${news.releasedate }"/>&nbsp;<a href="${pageContext.request.contextPath }/news/show/${news.newsid}" title="${news.title }">${fn:substring(news.title,0,10) }</a></li>
							</c:forEach>
						</ul>
					</div>
			</div>
		</div>
		<c:if test="${statu.index%3==2 || statu.last }">
			</div>
		</c:if>
	</c:forEach>

<jsp:include page="common/link.jsp"/>
<jsp:include page="common/foot.jsp"/>
</div>
</body>
<script type="text/javascript">
	var auto;
	var index=0;
	$('.tuhuo ul li').hover(function(){
		clearTimeout(auto);
		index=$(this).index();
		move(index);
		},function(){
			auto=setTimeout('autogo('+index+')',3000);
	});
	
	function autogo(){
		if(index<5){
			move(index);
			index++;
		}
		else{
			index=0;	
			move(index);
			index++;
		}
	}
	function move(l){
		var src=$('.tu_img').eq(index).attr('src');
		$("#fou_img").css({  "opacity": "0"  });
		$('#fou_img').attr('src',src);
		$('#fou_img').stop(true).animate({ opacity: '1'},1000);
		$('.tuhuo ul li').removeClass('fouce');
		$('.tuhuo ul li').eq(index).addClass('fouce');
		$('.tuhuo p').hide();
		$('.tuhuo p').eq(index).show();
		var ao=$('.tuhuo p').eq(index).children('a').attr('href');
		$('#fou_img').parent('a').attr("href",ao);
	}
	autogo();
	setInterval('autogo()',3000);
</script>

</html>