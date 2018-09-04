/** 计划行政班 */

	/** 明细计划Id     */ private Integer scpDId   ;
	/** 班级Id         */ private Integer claId    ;
	/** 行政班已排课时 */ private Byte    claLesNum;
	/** 班级类型       */ private Byte    claType  ; //代码类型(52) 1行政班、3升学班、4就业班
	/** 班级编号       */ private String  claNO    ;
	/** 班级名称       */ private String  claName  ;
	/** 年级代码       */ private Integer claGrade ; //代码类型(35)
	/** 专业代码       */ private Integer claMjaor ; //代码类型(3)
	/** 校区Id         */ private Integer claCamId ;
	/** 学部Id         */ private Integer claDepId ;
	/** 教室Id         */ private Integer claRomId ;

	/** 排序字段       */ private String[] orderFd; //排序字段的名称，倒序前面加“@”，可以多个
	/** 明细计划Id(组) */ private String   scpDIds; //多个用“,”隔开
	/** 班级Id(组)     */ private String   claIds ; //多个用“,”隔开

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询
	 * 使用者：
	 *
	 * URL：scpCla!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * scpDId       可选   明细计划Id
	 * claId        可选   班级Id
	 * claLesNum    可选   行政班已排课时
	 * claType      可选   班级类型 代码类型(52) 1行政班、3升学班、4就业班
	 * claNO        可选   班级编号
	 * claName      可选   班级名称
	 * claGrade     可选   年级代码 代码类型(35)
	 * claMjaor     可选   专业代码 代码类型(3)
	 * claCamId     可选   校区Id
	 * claDepId     可选   学部Id
	 * claRomId     可选   教室Id
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_ScpCla]}
	 *
	 */

	//==================================================================================================================
	// 新增
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：新增
	 * 使用者：
	 *
	 * URL：scpCla!newRec.action
	 *
	 * 参数
	 * scpDId    必需   明细计划Id
	 * claId     必需   班级Id
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功能信息","data":{V_ScpCla}}
	 *
	 */

	//==================================================================================================================
	// 删除
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：删除
	 * 使用者：
	 *
	 * URL：scpCla!del.action
	 *
	 * 参数
	 * scpDIds   必需   明细计划Id 多个用“,”隔开
	 * claIds    必需   班级Id 多个用“,”隔开
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

	//==================================================================================================================
