var moduleCode = '01005';

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
	$.post('./mgr/employees/reward/findEmployeesRewardList', {
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
			var type = v.type;
			var typeText = "";
			if(type==1){
				typeText = "奖励";
			}else{
				typeText = "惩罚"
			}
			$("<tr></tr>")
			.append($("<td></td>").append(v.id))
			.append($("<td></td>").append(v.name))
			.append($("<td></td>").append(emStateText))
			.append($("<td></td>").append(v.department))
			.append($("<td></td>").append(v.position))
			.append($("<td></td>").append(typeText))
			.append($("<td></td>").append(v.title))
			.append($("<td></td>").append(v.content))
			.append($("<td></td>").append(v.amount))
			.append($("<td></td>").append(v.creator))
			.append($("<td></td>").append(v.createTime))
			.append($("<td></td>").append(analysisBtns(v)))
			.appendTo(tbody);
		});
	}, 'json');
	// 获取分页信息
	$.post('./mgr/employees/reward/findEmployeesRewardCount', {
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
	$.getJSON('./mgr/employees/reward/findEmployeesByDepartment', {department : department}, function(data){
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
	$.getJSON('./mgr/employees/reward/findEmployeesByDepartment', {department : department}, function(data){
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
	btns += secure.modify ? "<button type='button' class='btn btn-primary btn-xs' onclick='showModifyBox("+v.id+","+ v.deptId + ")'><span class='glyphicon glyphicon-pencil'></span>编辑</button>" : "" ;
	btns += secure.del ? "<button type='button' class='btn btn-danger btn-xs' onclick='deleteReward("+v.id+")'><span class='glyphicon glyphicon-align-left'></span>删除</button>" : "" ;
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




function addReward(){
	var reward = {};
	$.isSubmit = true;
	reward.emId = $.verifyForm($('select.select-employees-add'), true);
	reward.type = $.verifyForm($('select.select-reward-add'), true);
	reward.title = $.verifyForm($('input.title'), true);
	reward.content = $.verifyForm($('textarea.content'), true);
	reward.amount = $.verifyForm($('input.amount'), true);
	if (!$.isSubmit) return;
	dialog = BootstrapDialog.isSubmitted();
	$.post('mgr/employees/reward/addEmployeesReward', {"data":JSON.stringify(reward)}, function(data) {
		dialog.close();
		if (!$.isSuccess(data)) return;
		BootstrapDialog.hideModel($('div.add-box'));
		BootstrapDialog.msg(data.body, BootstrapDialog.TYPE_SUCCESS);
		findListInfo();
	}, 'json');
}


function modifyReward(id) {
	var reward = {};
	if (!id) return;
	$.isSubmit = true;
	reward.id = id;
	reward.emId = $.verifyForm($('select.select-employees-modify'), true);
	reward.title = $.verifyForm($('input.modifyTitle'), true);
	reward.content = $.verifyForm($('textarea.modifyContent'), true);
	reward.amount = $.verifyForm($('input.modifyAmount'), true);
	if (!$.isSubmit) return;
	dialog = BootstrapDialog.isSubmitted();
	$.post('mgr/employees/reward/modifyReward', {"data":JSON.stringify(reward)}, function(data) {
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
function showModifyBox(id,deptId) {
	$('.empty').removeClass('empty');
	if (!id) return;
	dialog = BootstrapDialog.loading();
//	$('input.modifyName').val("");
//	$('textarea.modifyDesc').val("");
	findEmployeesByDepartmentOfModify(deptId);
	$.getJSON('mgr/employees/reward/findRewardById', {id : id}, function(data) {
		dialog.close();
		if (!$.isSuccess(data)) return;
		$('input.id').val(data.body.attenId);
		$('select.select-department-modify').val(data.body.deptId);
		$('select.select-employees-modify').val(data.body.emId);
//		$('select.select-employees').text(data.body.name);
		$('select.select-reward-modify').val(data.body.type);
		$('input.modifyTitle').val(data.body.title);
		$('input.modifyAmount').val(data.body.amount);
		$('textarea.modifyContent').val(data.body.content);
		
		$('button.modifyBtn').attr('onclick', 'modifyReward(' + data.body.id + ')');
		$('div.modify-box').modal({
			closable : false,
			show : true
		});
	});
}


function deleteReward(id){
	
	if (!id) return;
	BootstrapDialog.confirm("请确认是否要删除该考勤记录?", function(result) {
		if (!result) return;
		dialog = BootstrapDialog.isSubmitted();
		$.getJSON('mgr/employees/reward/deleteReward', {id : id}, function(data) {
			dialog.close();
			if (!$.isSuccess(data)) return;
			findListInfo();
			BootstrapDialog.msg(data.body, BootstrapDialog.TYPE_SUCCESS);
		});
	});
	
}