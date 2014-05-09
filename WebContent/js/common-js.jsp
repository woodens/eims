<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	getDeptLocal();
	getMgr();
	sum();
	$("#deptno").change(getDeptLocal);
	$("#mgrno").change(getMgr);
	$("#sal").blur(sum);
	$("#comm").blur(sum);
});
function getDeptLocal() {
	//选中的部门号
	var deptno = $("#deptno").children('option:selected').val();
	//遍历部门寻找跟选中部门号码相同的部门名
	<s:iterator  var="dept" value="deptList">
	if (deptno == <s:property value='deptno'/>) {
		$("#local").text("<s:property value='loc'/>");
		$("#hidden_dname").val("<s:property value='dname'/>");
		$("#hidden_local").val("<s:property value='loc'/>");
	}
	</s:iterator>
};
function getMgr() {
	//选中的上司号
	var deptno = $("#mgrno").children('option:selected').val();
	//遍历员工 寻找跟选中上司号码相同的上司名
	<s:iterator  var="mgr" value="mgrList">
	if (deptno == <s:property value='mgrno'/>) {
		$("#hidden_mgrname").val("<s:property value='mname'/>");
	}
	</s:iterator>
};
function trim(str) {
	var result;
	result = str.replace(/(^\s+)|(\s+$)/g, "");
	return result;
};

function sum() {
	var sum = "";
	var sal = $("#sal").val();
	var comm = $("#comm").val();
	if (trim(sal) == "" && trim(comm) == "") {
		sum = "";
	} else {
		if ((trim(sal) != "" && isNaN(sal))
				|| (trim(comm) != "" && isNaN(comm))) {
			sum = "";
		} else {
			if (trim(sal) != "" && trim(comm) != "") {
				sum = Number(sal) + Number(comm);
			} else if (trim(sal) != "" && trim(comm) == "") {
				sum = Number(sal);
			} else {
				sum = Number(comm);
			}
		}
	}
	$("#sum").text(sum);
	$("#hidden_sum").val(sum);
};
</script>