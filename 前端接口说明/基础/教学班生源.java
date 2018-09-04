/** 教学班生源 */


	/** 教学班Id     */ private Integer tccId   ;
	/** 行政班Id     */ private Integer claId   ;
	/** 教学班类型   */ private Byte    tccType ; //代码类型52 2教学班(默认)、8选课班、9任课班
	/** 教学班编号   */ private String  tccNO   ;
	/** 教学班名称   */ private String  tccName ;
	/** 教学班年级   */ private Integer tccGrade; //系统代码35
	/** 教学班专业   */ private Integer tccMajor; //系统代码3
	/** 教学班校区Id */ private Integer tccCamId;
	/** 教学班学部Id */ private Integer tccDepId;
	/** 班级类型     */ private Byte    claType ; //代码类型(52) 1行政班、3升学班、4就业班
	/** 班级编号     */ private String  claNO   ;
	/** 班级名称     */ private String  claName ;
	/** 年级代码     */ private Integer claGrade; //代码类型(35)
	/** 专业代码     */ private Integer claMajor; //代码类型(3)
	/** 校区Id       */ private Integer claCamId;
	/** 学部Id       */ private Integer claDepId;

	/** 排序字段     */ private String[] orderFd; //排序字段的名称，倒序前面加“@”，可以多个
	/** 教学班Id(组) */ private String   tccIds ; //多个用“,”隔开
	/** 行政班Id(组) */ private String   claIds ; //多个用“,”隔开

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询
	 * 使用者：
	 *
	 * URL：public/tccStuSrc!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * tccId        可选   教学班Id
	 * claId        可选   行政班Id
	 * tccType      可选   教学班类型 代码类型52 2教学班(默认)、8选课班、9任课班
	 * tccNO        可选   教学班编号
	 * tccName      可选   教学班名称
	 * tccGrade     可选   教学班年级 系统代码35
	 * tccMajor     可选   教学班专业 系统代码3
	 * tccCamId     可选   教学班校区Id
	 * tccDepId     可选   教学班学部Id
	 * claType      可选   班级类型 代码类型(52) 1行政班、3升学班、4就业班
	 * claNO        可选   班级编号
	 * claName      可选   班级名称
	 * claGrade     可选   年级代码 代码类型(35)
	 * claMajor     可选   专业代码 代码类型(3)
	 * claCamId     可选   校区Id
	 * claDepId     可选   学部Id
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_TccStuSrc]}
	 *
	 */


	//==================================================================================================================
	// 新增
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：新增
	 * 使用者：
	 *
	 * URL：public/tccStuSrc!newRec.action
	 *
	 * 参数
	 * tccId  必需   教学班Id
	 * claId  必需   行政班Id
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功能信息"}
	 *
	 */


	//==================================================================================================================
	// 删除
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：删除
	 * 使用者：
	 *
	 * URL：public/tccStuSrc!del.action
	 *
	 * 参数
	 * tccId    必需   教学班Id
	 * claIds   必需   行政班Id 多个用“,”隔开
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */


	//==================================================================================================================
