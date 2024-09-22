var moduleCode = '02002';

function initFun() {
	if (secure.find) {
		findDepartmentOfSearch();
		findDepartmentOfAdd();
		findDepartmentOfModify();
		findListInfo();
		dialog = BootstrapDialog.loading();
	}
	if(!secure.add) $('button.add-empl-btn').remove();
	if(secure.add ) $('button.add-empl-btn').removeClass('hide');
}

$(function() {
	$('.search-select, .dropdown-menu').on('click', function(e) {
		$target = $(e.target);
		var searchBtn = $('button.search-btn');
		searchBtn.text($target.text());
		searchBtn.append("<span class='caret'></span>");
		searchBtn.attr('name', $target.attr('name'));
	});
	$('select.select-department-search').change(function(e){
		findPosition($(this).val());
	});
	
	$('select.select-department-add').change(function(e){
		findEmployeesByDepartmentOfAdd($(this).val());
	});
	
	$('select.select-department-modify').change(function(e){
		findEmployeesByDepartmentOfModify($(this).val());
	});
});


/*
 * 获取考勤列表信息
 * te5l.com [K]
 */
function findListInfo() {
	var serType = $('button.search-btn').attr('name');
	var serVal = $('input.search-val').val();
	var department = $('select.select-department-search').val();
	var position = $('select.select-position-search').val();
	var emType = $('select.select-emType').val();
	$.post('./mgr/employees/Emolument/findEmployeesEmolumentList', {
		serType : serType,
		serVal : serVal,
		department : department,
		position : position,
		page : page,
		emplType : emType
	}, function(data) {
		var tbody = $('tbody.tbody-info').empty();
		dialog.close();
		if(!$.isSuccess(data)) return;
		$.each(data.body, function(i,v){
			var emState = v.emState;
			var emStateText = "";
			if(emState == 1){
				emStateText = "实习员工";
			}else if(emState == 2){
				emStateText = "正式员工";
			}else{
				emStateText = "离职员工";
			}
			$("<tr></tr>")
			.append($("<td></td>").append(v.emoId))
			.append($("<td></td>").append(v.name))
			.append($("<td></td>").append(emStateText))
			.append($("<td></td>").append(v.department))
			.append($("<td></td>").append(v.position))
			.append($("<td></td>").append(v.identity))
			.append($("<td></td>").append(v.salary))
			.append($("<td></td>").append(analysisBtns(v)))
			.appendTo(tbody);
		});
	}, 'json');
	// 获取分页信息
	$.post('./mgr/employees/Emolument/findEmployeesEmolumentCount', {
		serType : serType,
		serVal : serVal,
		department : department,
		position : position,
		page : page,
		emplType : emType
	}, function(data) {$.analysisPage(data.body);}, 'json');
}

/*
 * 获取部门列表
 * te5l.com [K]
 */
function findDepartmentOfSearch(){
	$.getJSON('./mgr/findDepartment', function(data){
		var departmentList = $('select.select-department-search').empty().append("<option value=0>请选择部门</option>");
		if(!$.isSuccess(data)) return;
		$.each(data.body, function(i,v){
			$('<option value='+v.id+'></option>').append(v.name).appendTo(departmentList);
		});
	});
}

/*
 * 获取部门列表
 * te5l.com [K]
 */
function findDepartmentOfAdd(){
	$.getJSON('./mgr/findDepartment', function(data){
		var departmentList = $('select.select-department-add').empty().append("<option value=0>请选择部门</option>");
		if(!$.isSuccess(data)) return;
		$.each(data.body, function(i,v){
			$('<option value='+v.id+'></option>').append(v.name).appendTo(departmentList);
		});
	});
}

/*
 * 获取部门列表
 * te5l.com [K]
 */
function findDepartmentOfModify(){
	$.getJSON('./mgr/findDepartment', function(data){
		var departmentList = $('select.select-department-modify').empty().append("<option value=0>请选择部门</option>");
		if(!$.isSuccess(data)) return;
		$.each(data.body, function(i,v){
			$('<option value='+v.id+'></option>').append(v.name).appendTo(departmentList);
		});
	});
}

/*
 * 根据部门ID, 获取职位列表
 * te5l.com [K]
 */
function findPosition(deptId){
	var positionList = $('select.select-position-search').empty().append("<option value=0>请选择职位</option>");
	if(deptId < 1) return;
	$.getJSON('./mgr/findPositionByDeptId', {deptId : deptId}, function(data){
		if(!$.isSuccess(data)) return;
		$.each(data.body, function(i, v){
			$('<option value='+v.id+'></option>').append(v.name).appendTo(positionList);
		});
	});
}

/*
 * 根据部门ID,和职位获取员工列表
 * te5l.com [K]
 */
function findEmployeesByDepartmentOfAdd(department){
	var positionList = $('select.select-employees-add').empty().append("<option value=0>请选择员工</option>");
	if(department < 1) return;
	$.getJSON('./mgr/employees/Emolument/findEmployeesByDepartment', {department : department}, function(data){
		if(!$.isSuccess(data)) return;
		$.each(data.body, function(i, v){
			$('<option value='+v.id+'></option>').append(v.name).appendTo(positionList);
		});
	});
}

/*
 * 根据部门ID,和职位获取员工列表
 * te5l.com [K]
 */
function findEmployeesByDepartmentOfModify(department){
	var positionList = $('select.select-employees-modify').empty().append("<option value=0>请选择员工</option>");
	if(department < 1) return;
	$.getJSON('./mgr/employees/Emolument/findEmployeesByDepartment', {department : department}, function(data){
		if(!$.isSuccess(data)) return;
		$.each(data.body, function(i, v){
			$('<option value='+v.id+'></option>').append(v.name).appendTo(positionList);
		});
	});
}



/*
 * 解析按钮组
 * te5l.com [K]
 */
function analysisBtns(v){
	var btns = "";
	btns += secure.modify ? "<button type='button' class='btn btn-primary btn-xs' onclick='showModifyBox("+v.emoId+","+ v.deptId + ")'><span class='glyphicon glyphicon-pencil'></span>编辑</button>" : "" ;
	btns += secure.del ? "<button type='button' class='btn btn-danger btn-xs' onclick='deleteEmolument("+v.emoId+")'><span class='glyphicon glyphicon-align-left'></span>删除</button>" : "" ;
	return btns;
}


/*
 * 显示部门添加窗口 
 * te5l.com [K]
 */
function showAddBox() {
	$('.empty').removeClass('empty');
	$('input.addName').val('');
	$('textarea.addDesc').val('');
	BootstrapDialog.showModel($('div.add-box'));
}




function addEmolument(){
	var emolument = {};
	$.isSubmit = true;
	emolument.emId = $.verifyForm($('select.select-employees-add'), true);
	emolument.salary = $.verifyForm($('input.salary_add'), true);
	if (!$.isSubmit) return;
	dialog = BootstrapDialog.isSubmitted();
	$.post('mgr/employees/Emolument/addEmployeesEmolument', {"data":JSON.stringify(emolument)}, function(data) {
		dialog.close();
		if (!$.isSuccess(data)) return;
		BootstrapDialog.hideModel($('div.add-box'));
		BootstrapDialog.msg(data.body, BootstrapDialog.TYPE_SUCCESS);
		findListInfo();
	}, 'json');
}


function modifyEmolument(emoId) {
	var emolument = {};
	if (!emoId) return;
	$.isSubmit = true;
	emolument.emoId = emoId;
	emolument.emId = $.verifyForm($('select.select-employees-modify'), true);
	emolument.salary = $.verifyForm($('input.salary_modify'), true);
	if (!$.isSubmit) return;
	dialog = BootstrapDialog.isSubmitted();
	$.post('mgr/employees/Emolument/modifyEmolument', {"data":JSON.stringify(emolument)}, function(data) {
		dialog.close();
		if (!$.isSuccess(data)) return;
		BootstrapDialog.hideModel($('div.modify-box'));
		BootstrapDialog.msg(data.body, BootstrapDialog.TYPE_SUCCESS);
		findListInfo();
	}, 'json');
}


/*
 * 显示部门编辑窗口 
 * te5l.com [K]
 */
function showModifyBox(emoId,deptId) {
	$('.empty').removeClass('empty');
	if (!emoId) return;
	dialog = BootstrapDialog.loading();
//	$('input.modifyName').val("");
//	$('textarea.modifyDesc').val("");
	findEmployeesByDepartmentOfModify(deptId);
	$.getJSON('mgr/employees/Emolument/findEmolumentById', {emoId : emoId}, function(data) {
		dialog.close();
		if (!$.isSuccess(data)) return;
		$('select.select-department-modify').val(data.body.deptId);
		$('select.select-employees-modify').val(data.body.emId);
//		$('select.select-employees').text(data.body.name);
		$('input.salary_modify').val(data.body.salary);
		
		$('button.modifyBtn').attr('onclick', 'modifyEmolument(' + emoId + ')');
		$('div.modify-box').modal({
			closable : false,
			show : true
		});
	});
}


function deleteEmolument(emoId){
	
	if (!emoId) return;
	BootstrapDialog.confirm("请确认是否要删除该考勤记录?", function(result) {
		if (!result) return;
		dialog = BootstrapDialog.isSubmitted();
		$.getJSON('mgr/employees/Emolument/deleteEmolument', {emoId : emoId}, function(data) {
			dialog.close();
			if (!$.isSuccess(data)) return;
			findListInfo();
			BootstrapDialog.msg(data.body, BootstrapDialog.TYPE_SUCCESS);
		});
	});
	
}