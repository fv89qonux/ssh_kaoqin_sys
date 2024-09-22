var moduleCode = '05001';
var note = {};
function initFun() {
	if (secure.find) {
		findListInfo();
		dialog = BootstrapDialog.loading();
	}
	if(!secure.add) $('button.add-empl-btn').remove();
	if(secure.add ) $('button.add-empl-btn').removeClass('hide');
}


/*
 * 新窗口打开新建员工信息页面
 * te5l.com [K]
 */
function newInternshipEmpl() {
	window.open('./system_note_info.html?moduleCode=05001');
}

/*
 * 获取公告列表信息
 * te5l.com [K]
 */
function findListInfo() {
	var serVal = $('input.search-val').val();
	$.post('./mgr/note/findNotesList', {
		serVal : serVal,
		page : page
	}, function(data) {
		var tbody = $('tbody.tbody-info').empty();
		dialog.close();
		if(!$.isSuccess(data)) return;
		$.each(data.body, function(i,v){
			$("<tr></tr>")
			.append($("<td></td>").append(v.id))
			.append($("<td></td>").append(v.title))
			.append($("<td></td>").append(v.creator))
			.append($("<td></td>").append(v.createTime))
			.append($("<td></td>").append(analysisBtns(v)))
			.appendTo(tbody);
		});
	}, 'json');
	// 获取分页信息
	$.post('./mgr/note/findNotesPage', {
		serVal : serVal,
		page : page
	}, function(data) {$.analysisPage(data.body);}, 'json');
}


/*
 * 提示并删除帐号列表
 * te5l.com [K]
 */
function hintDelete(id){
	if(!id) return;
	BootstrapDialog.confirm("请确定是否删除该帐号?", function(result){
		if(!result) return;
		dialog = BootstrapDialog.isSubmitted();
		$.getJSON('./mgr/note/delNote', {id:id}, function(data){
			dialog.close();
			if(!$.isSuccess(data)) return;
			BootstrapDialog.msg(data.body, BootstrapDialog.TYPE_SUCCESS);
			findListInfo();
		});
	});
}


/*
 * 解析按钮组
 * te5l.com [K]
 */
function analysisBtns(v){
	var btns = "";
	btns += secure.modify ? "<button type='button' class='btn btn-primary btn-xs' onclick='modifyNotesInfo("+v.id+")'><span class='glyphicon glyphicon-pencil'></span>编辑</button>" : "" ;
	btns += secure.find ? "<button type='button' class='btn btn-success btn-xs' onclick='findNotesInfo("+v.id+")'><span class='glyphicon glyphicon-align-left'></span>详情</button>" : "" ;
	btns += secure.del ? "<button type='button' class='btn btn-danger btn-xs' onclick='hintDelete(" + v.id + ")'><span class='glyphicon glyphicon-remove'></span>删除</button>" : "";
	return btns;
}
/*
 * 跳转到编辑页面
 * te5l.com [K]
 */
function modifyNotesInfo(id){ 
	if(!id) return;
	window.open('./system_note_info.html?moduleCode=05001&id='+id);
}


/*
 * 跳转到查询页面
 * te5l.com [K]
 */
function findNotesInfo(id){ 
	if(!id) return;
	window.open('./system_note_view.html?moduleCode=05001&id='+id);
}


