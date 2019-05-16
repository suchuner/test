$(function(){
		$.post("baseDict_findByTypeCode",{"dict_type_code":"002"},function(data){
			$(data).each(function(i,obj){
			$("#customerSource").append("<option value = '"+obj.dict_id+"'>"+obj.dict_item_name+"</option>");
			});
			$("#customerSource option[value ='${model.baseDictSource.dict_id}']").prop("selected","selected");
		},"json");
		$.post("baseDict_findByTypeCode",{"dict_type_code":"006"},function(data){
			$(data).each(function(i,obj){
			$("#customerLevel").append("<option value = '"+obj.dict_id+"'>"+obj.dict_item_name+"</option>");
			});
			$("#customerLevel option[value ='${model.baseDictLevel.dict_id}']").prop("selected","selected");
		},"json");
		$.post("baseDict_findByTypeCode",{"dict_type_code":"001"},function(data){
			$(data).each(function(i,obj){
			$("#customerIndustry").append("<option value = '"+obj.dict_id+"'>"+obj.dict_item_name+"</option>");
			});
			$("#customerIndustry option[value ='${model.baseDictIndustry.dict_id}']").prop("selected","selected");
		},"json");
	});