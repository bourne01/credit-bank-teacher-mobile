/** 教学班计划 */

	/** 排课计划Id   */ private Integer scpId   ;
	/** 教学班Id     */ private Integer tccId   ;
	/** 初始课表     */ private Long    iniSched;
	/** 排课学期Id   */ private Integer termId  ;
	/** 教学班类型   */ private Byte    tccType ; //代码类型52 2教学班(默认)、8选课班、9任课班
	/** 教学班编号   */ private String  tccNO   ;
	/** 教学班名称   */ private String  tccName ;
	/** 教学班年级   */ private Integer tccGrade; //系统代码35
	/** 教学班专业   */ private Integer tccMajor; //系统代码3
	/** 教学班学部Id */ private Integer tccDepId;
	/** 学部名称     */ private String  tccDepNm;

	/** 排序字段     */ private String[] orderFd    ; //排序字段的名称，倒序前面加“@”，可以多个
	/** 教学班Id(组) */ private String   tccIds     ; //多个用“,”隔开
    /** 位化课表     */ private String   bitStrSched;
    /** 返回周课表   */ private Byte     rtnCurSched;

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询
	 * 使用者：+ 部门负责人(自己负责的部门)
	 *
	 * URL：schTccPlan!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * scpId        必需   排课计划Id
	 * tccId        可选   教学班Id
	 * iniSched     可选   初始课表
	 * termId       可选   排课学期Id
	 * tccType      可选   教学班类型 代码类型52 2教学班(默认)、8选课班、9任课班
	 * tccNO        可选   教学班编号
	 * tccName      可选   教学班名称
	 * tccGrade     可选   教学班年级 系统代码35
	 * tccMajor     可选   教学班专业 系统代码3
	 * tccDepId     可选   教学班学部Id
	 * tccDepNm     可选   学部名称
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 * rtnCurSched  可选   1=返回当前课表（还必需指定scpId参数），默认不返回
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_SchTccPlan]}
	 *
	 */

	//==================================================================================================================
	// 保存
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：保存
	 * 使用者：+ 部门负责人
	 *
	 * URL：schTccPlan!saveRec.action
	 *
	 * 参数
	 * scpId        必需   排课计划Id
	 * tccId        必需   教学班Id
	 * bitStrSched  可选   初始课表
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功能信息","data":{SchTccPlan}}
	 *
	 */

	//==================================================================================================================
	// 删除
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：删除
	 * 使用者：
	 *
	 * URL：schTccPlan!del.action
	 *
	 * 参数
	 * scpId    必需   排课计划Id
	 * tccIds   必需   教学班Id 多个用“,”隔开
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

	//==================================================================================================================
