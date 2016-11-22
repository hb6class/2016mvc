<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style></style>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		$(".page2,.page3,.page4").hide();
		
		$(".menu>a").eq(0).click(function() {
		$(".page1,.page3,.page4").hide();
		$(".page2").show();
			//alert("첫번째 버튼 클릭됨");
			$.ajax("list.do",{
				"dataType":"json",
				"error":function(jqXHR, textStatus){
					alert(textStatus);
				},
				"success":function(data){
					var msg="";
					var alist=data.tlist;
					for(i=0; i<alist.length; i++){
						msg+="<div>"
						+"<span>"+alist[i].sabun+"</span>"
						+"<span>"+alist[i].name+"</span>"
						+"<span>"+alist[i].nalja+"</span>"
						+"<span>"+alist[i].pay+"</span>"
						+"</div>";
					}
					$(".page2").html(msg);
				}
			});
			return false;
		});//a-0 end
		
		$(".menu>a").eq(1).click(function() {
			$(".page1,.page2,.page4").hide();
			$(".page3").show();
			return false;
		});//a-1 end
		
		$(".page3>form").submit(function() {
			//alert("form start");
			var sabun = $("#sabun").val();
			var name = $("#name").val();
			var pay = $("#pay").val();
			$.ajax("add.do",{
				"data":{"sabun":sabun,
						"name":name,
						"pay":pay
						},
				"method":"POST",
				"error":function(jqXHR, textStatus){
					alert(textStatus);
				},
				"success":function(){
					$(".menu>a").eq(0).click();
				}
				});
				sabun = $("#sabun").val("");
				name = $("#name").val("");
				pay = $("#pay").val("");
			return false;
		});//add form end
		
		$(".page2").on("click","div",function(e) {
			$(".page1,.page2,.page3").hide();
			$(".page4").show();
			$(".page4 input").hide();
			var sabun=$(this).children("span").eq(0).text();
			$.post("detail.do",{"sabun":sabun},function(data){
				temp=$(".page4").find(".data");
				$(temp[0]).text(data.detail[0].sabun);
				$(temp[1]).text(data.detail[0].name);
				$(temp[2]).text(data.detail[0].nalja);
				$(temp[3]).text(data.detail[0].pay);
				var input=$(".page4 input");
				$(input[0]).val(data.detail[0].sabun);
				$(input[1]).val(data.detail[0].name);
				$(input[2]).val(data.detail[0].pay);
				}
			);//post end
		});//click div end
		$(".page4").on("click","button",function(e) {
			if($(".page4 button").text()=="EDIT"){
				var sabun =$(".page4 input").eq(0).val();
				var name =$(".page4 input").eq(1).val();
				var pay =$(".page4 input").eq(2).val();
				alert(sabun+name+pay);
				$.ajax({
						"url":"edit.do",
						"data":{
							"name":name,
							"pay":pay,
							"sabun":sabun
						},
						"method":"put",
						"error":function(jqXHR, textStatus){
							alert(textStatus);
						},
						"success":function(){
							$(".menu>a").eq(0).click();
						}
				});
			}else{
			$(".page4 button").text("EDIT");
			$(".page4 input").show();
			$(".page4 .data").hide();				
			}
			
		});
	});// ready end
	var temp;
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<img alt="" src="./imgs/logo_ai.png" />
	</div>
	<div class="menu">
		<a href="#">LIST</a>
		<a href="#">ADD</a>
	</div>
	<div class="page1">
		<img alt="" src="./imgs/main.jpg" />
	</div>
	<div class="page2">
		<img alt="" src="./imgs/main.jpg" />
	</div>
	<div class="page3">
		<h1>입력 페이지</h1>
		<form>
		<p>
			<label for="sabun">sabun</label>
			<input type="text" name="sabun" id="sabun" />
		</p>
		<p>
			<label for="name">name</label>
			<input type="text" name="name" id="name" />
		</p>
		<p>
			<label for="pay">pay</label>
			<input type="text" name="pay" id="pay" />
		</p>
		<p><button type="submit">입력</button></p>
		</form>
	</div>
	<div class="page4">
		<h1>상세페이지</h1>
		<p><span>sabun</span><span class="data"></span>
		<input type="text" id="sabun" /></p>
		<p><span>name</span><span class="data"></span>
		<input type="text" id="name" /></p>
		<p><span>nalja</span><span class="data"></span></p>
		<p><span>pay</span><span class="data"></span>
		<input type="text" id="pay" /></p>
		<p><button>수정</button> </p>
	</div>
</body>
</html>














