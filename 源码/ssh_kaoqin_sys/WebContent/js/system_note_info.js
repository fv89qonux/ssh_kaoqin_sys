var note = {};	// 员工所有信息
var submitText = '提交信息失败, 请注意被标识为红色的部分!';

var moduleCode = $.getUrlParam('moduleCode');
moduleCode = !moduleCode ? '05001' : moduleCode;	// 获取url传递过来的模块编号, 默认为01001
note.id = !$.getUrlParam('id') ? 0 : $.getUrlParam('id');	// 员工ID
// 动态生成url, 通过获取员工编号来决定
var url = !$.getUrlParam('id') ? 'saveNotesInfo' : 'modifyNotesInfo';


function initFun() {
	if(!secure.find)  $('div.edit-notes-box').remove();
	if(secure.find){
		dialog = BootstrapDialog.loading();
		$('div.edit-notes-box').removeClass('hide');
		if(note.id){
			addBreadcrumb('修改公告信息');
			$.findNotesInfo(note.id);
			return;
		}
		$('div.new-title').text("新增公告信息");
	}
	dialog.close();
}
/*
 * jQuery 扩展
 * te5l.com [K]
 */
(function($){

	// 验证文本框, 传入获取文本框元素的标识, 是否为空,  加正则匹配
	$.input = function(className, empty, regular){
		$(className).parent().prev().removeClass('data-empty');
		var val = $.removeTrim($(className).val());
		if(!empty) return val;
		if(empty && !regular && val) return val;
		if(regular != null && regular.test(val)) return val;
		$.isSubmit = false;
		$(className).parent().prev().addClass('data-empty');
	};
})(jQuery);


/*
 * 验证表单数据
 * te5l.com [K]
 */
function detectionForm(){
	$.isSubmit = true;	// 重置表单为可提交
	// 基本信息
	note.title = $.input('.title', true, null);	// 标题
	note.content = $.input('.content', true, null);	// 身份证号码
	if(!$.isSubmit)
		BootstrapDialog.msg(submitText, BootstrapDialog.TYPE_DANGER);
	return $.isSubmit;
};



/*
 * 保存员工信息
 * te5l.com [K]
 */
function saveOrModifyNotesInfo(){ 
	detectionForm();
	if(!$.isSubmit) return;
	dialog = BootstrapDialog.isSubmitted();
	$.post('./mgr/note/'+url,{data : JSON.stringify(note)}, function(data){
		dialog.close();
		if(!$.isSuccess(data)) return;
		BootstrapDialog.show({
			title:"提示信息",
			type:BootstrapDialog.TYPE_SUCCESS,
			closable : true,
			message : "公告信息保存成功!",
			onhidden : function(dialogRef) {
				window.location.href = "system_note.html?moduleCode="+moduleCode+"&id=" + data.body;
			}
		});
	}, 'json');
};
/*
 * 获取员工基本信息
 * te5l.com [K]
 */
$.findNotesInfo = function(id){
	if(!id) return;
	$.getJSON('./mgr/note/findNotesInfo',{id:id}, function(data){
		if(!$.isSuccess(data)) return;
		var info = data.body;
		$('input.title').val(info.title);
		$('div.new-title').text("修改公告 \""+info.title+"\" 信息");
		$('textarea.content').val(info.content);
		dialog.close();
		//$('select, input, textarea').prop('disabled', true);
	});
};