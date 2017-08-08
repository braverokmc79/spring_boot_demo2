   
$(".answer-write input[type=submit]").click(addAnswer);

$(".link-delete-article").click(deleteAnswer);


function addAnswer(e){	
    	e.preventDefault();
    	console.log("click!");

		var queryString=$(".answer-write").serialize();
		console.log("query : " +queryString);
		
		var url =$(".answer-write").attr("action");
		console.log("url : " + url);
		
		$.ajax({
			type:'post',
			url :url,
			data: queryString,
			dataType :'json',
			error :onError,
			success:onSuccess
			
		});	
}


function onError(){
	console.log("error");
}

function onSuccess(data, status){
	console.log(data);
	var answerTemplate =$("#answerTemplate").html();
	var template =answerTemplate.format(data.writer.userId, data.formattedCreateDate, data.contents, data.questionId, data.id);
	$(".qna-comment-slipp-articles").prepend(template);
	$("textarea[name=contents]").val("");
	countAnswer(true);
}

String.prototype.format = function() {
	  var args = arguments;
	  return this.replace(/{(\d+)}/g, function(match, number) {
	    return typeof args[number] != 'undefined'
	        ? args[number]
	        : match
	        ;
	  });
};


function deleteAnswer(e){
	
	e.preventDefault();
	var url =$(this).attr("href");
	console.log("답변 삭제"  + url);
	var thisDelete=$(this);
	
	$.ajax({
		type :'delete',
		url: url,
		dataType : 'json',
		error :function (xhr, status){
			console.log("error");
		},
		success:function(data, status){
			console.log(data);
			if(data.valid){
				thisDelete.closest('article').remove();	
				countAnswer(false);
			}else{
				alert(data.errorMessage);
			}
		}
	});
	
}


function countAnswer(check){
	var count =$(".qna-comment-count strong");
	var countNum =count.text();
	if(check)count.text(parseInt(countNum)+1);
	else count.text(parseInt(countNum)-1);	
}
    




