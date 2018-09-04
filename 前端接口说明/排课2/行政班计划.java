/** 行政班计划 */

	/** 排课计划Id */ private Integer scpId   ;
	/** 行政班Id   */ private Integer claId   ;
	/** 初始课表   */ private Long    iniSched;
	/** 排课学期Id */ private Integer termId  ;
	/** 班级类型   */ private Byte    claType ; //代码类型(52) 1行政班、3升学班、4就业班
	/** 班级编号   */ private String  claNO   ;
	/** 班级名称   */ private String  claName ;
	/** 年级代码   */ private Integer claGrade; //代码类型(35)
	/** 专业代码   */ private Integer claMajor; //代码类型(3)
	/** 学部Id     */ private Integer claDepId;
	/** 学部名称   */ private String  claDepNm;

	/** 排序字段     */ private String[] orderFd    ; //排序字段的名称，倒序前面加“@”，可以多个
	/** 行政班Id(组) */ private String   claIds     ; //多个用“,”隔开
    /** 位化课表     */ private String   bitStrSched;
    /** 返回周课表   */ private Byte     rtnCurSched;

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询
	 * 使用者：+ 部门负责人(自己负责的部门)
	 *
	 * URL：schClaPlan!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * scpId        必需   排课计划Id
	 * claId        可选   行政班Id
	 * iniSched     可选   初始课表
	 * termId       可选   排课学期Id
	 * claType      可选   班级类型 代码类型(52) 1行政班、3升学班、4就业班
	 * claNO        可选   班级编号
	 * claName      可选   班级名称
	 * claGrade     可选   年级代码 代码类型(35)
	 * claMajor     可选   专业代码 代码类型(3)
	 * claDepId     可选   学部Id
	 * claDepNm     可选   学部名称
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 * rtnCurSched  可选   1=返回当前课表（还必需指定scpId参数），默认不返回
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_SchClaPlan]}
	 *
	 */

	//==================================================================================================================
	// 保存
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：保存
	 * 使用者：+ 部门负责人
	 *
	 * URL：schClaPlan!saveRec.action
	 *
	 * 参数
	 * scpId        必需   排课计划Id
	 * claId        必需   行政班Id
	 * bitStrSched  可选   初始课表
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功能信息","data":{SchClaPlan}}
	 *
	 */

	//==================================================================================================================
	// 删除
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：删除
	 * 使用者：
	 *
	 * URL：schClaPlan!del.action
	 *
	 * 参数
	 * scpId    必需   排课计划Id
	 * claIds   必需   行政班Id 多个用“,”隔开
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

	//==================================================================================================================
