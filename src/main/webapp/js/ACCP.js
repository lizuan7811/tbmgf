$.fn.pageTurnFunc=(function(receiveData)
{
	// 開始頁
	var startPage=1;
	// 結束頁
	var endPage;
	// 目前頁
	var curPage;
	// 每頁限制row數
	var limitRows=20;
	// 資料的總row數
	var totoalRows;
	// 結束row數
	var endRows;
	// 所有資料的陣列(有序)
	var dataArr=new Array();
	dataArr=receiveData;
	var allTB=$(".mainBox_table");
	var curTB=$("#curTB");
	var allTB=$("#allTB");
	// 將直傳入
	$(function(dataArr)
	{
		var tpallTB=Math.floor(dataArr.length/limitRows);
		if(Math.floor(dataArr.length%limitRows)==0)
		{
			allTB=tpallTB+1;
		}else{
			allTB=tpallTB;
		}
	});
	
});


// <!-- <script type="text/javascript">
// 			$(document).ready(function(){
// 				$.ajax({
// 					url:"ajaxServlet",
// 					data:{},
// 					type:"post",
// 					success:function(data){
// 						console.log(data);
// 						var data2=JSON.parse(data);
// 						console.log(data2.count);
// 						$("#try1").click(function(){
// 							$("#try1").append("\<li>"+data2.username+"\</li>");
// 						});
// 					},
// 					error:function(data)
// 					{
						
// 					}
// 				})
				
// 			})
		
		
		
		
// 		</script> -->











$(document).ready(function(){
				$.ajax({
					url:"userlist",
					data:{"metChoice":"getUserList","usPos":"3"},
					type:"post",
					success:function(data){
						var data2=JSON.parse(data);
						var pjArr=new Array();
						$(document).ready(function()
						{
							var i=1;
							for(var key in data2)
							{
								if(data2[key].suspended>0)
								{
								pjArr.push('<tr><td>&nbsp;<input type="checkbox" class="ckBox" name="selectbox" value="">&nbsp;</td><td>'+i+'</td><td>'+data2[key].name+'</td><td>'+data2[key].nickName+'</td><td>'+data2[key].account+'</td><td>'+data2[key].email+'</td><td>0</td><td>'+data2[key].diaryReportedNum+'</td><td>'+data2[key].commentReportedNum+'</td><td>0</td><td><input type="button" name="open" value="解除禁用"/>&nbsp;<input type="button" name="close" value="禁止權限" disabled="disabled"/></td></tr>');									
								}
								else
								{
								pjArr.push('<tr><td>&nbsp;<input type="checkbox" class="ckBox" name="selectbox" value="">&nbsp;</td><td>'+i+'</td><td>'+data2[key].name+'</td><td>'+data2[key].nickName+'</td><td>'+data2[key].account+'</td><td>'+data2[key].email+'</td><td>0</td><td>'+data2[key].diaryReportedNum+'</td><td>'+data2[key].commentReportedNum+'</td><td>0</td><td><input type="button" name="open" value="解除禁用" disabled="disabled"/>&nbsp;<input type="button" name="close" value="禁止權限"/></td></tr>');									
								}
								i=i+1;
							}
							console.log(pjArr);
							for(var j=0;j<pjArr.length;j++){
								$(".mainBox_table").append(pjArr[j]);
								if(j>23)
								{
									$("#mainBox_Content_div").addClass(".autoScrollY");
								}
							}
						});
						
						},
					error:function(data)
					{
					}
				})
			})
		