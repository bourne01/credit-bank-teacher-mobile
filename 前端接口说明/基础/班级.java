/** 班级 */

    /** 班级Id   */ private Integer autoId       ;
    /** 类型     */ private Byte    type         ;
    /** 班级编号 */ private String  nO           ;
    /** 班级名称 */ private String  name         ;
    /** 年级代码 */ private Integer grade        ;
    /** 专业代码 */ private Integer major        ;
    /** 校区Id   */ private Integer camId        ;
    /** 学部Id   */ private Integer depId        ;
    /** 教室Id   */ private Integer claRomId     ;
    /** 班主任Id */ private Integer masterId     ;
    /** 男生数   */ private Integer boyCount     ;
    /** 女生数   */ private Integer girlCount    ;
    /** 入学人数 */ private Integer startManCount;
    /** 入学成绩 */ private Double  startResult  ;
    /** 开班日期 */ private Date    joinDate     ;
    /** 结束日期 */ private Date    gradDate     ;
    /** 是否在校 */ private Byte    inSchool     ;
    /** 状态     */ private Byte    state        ; //1草稿、2正常(默认)、3关闭、4历史
	/** 名单维护 */ private Byte    setStu       ; //2任教老师、3高级用户(默认)、4关闭维护 代码类型(53)
    /** 备注     */ private String  remark       ;
    /** 校区名称 */ private String  camName      ;
    /** 部门名称 */ private String  depName      ;
    /** 教室名称 */ private String  romName      ;
    /** 教师名称 */ private String  thrName      ;

    /** 排序方式   */ private Byte   order;
	/** 班级Id(组) */ private String autoIds; //多个用“,”隔开

    //==================================================================================================================
    // 查询 -- 基本信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询 -- 基本信息
     * 使用者：无限制
     *
     * URL：public/cla!query.action
     *
     * 参数：
     * start      可选   记录开始位置
     * limit      可选   获取记录数量
     * autoId     可选   班级Id
     * type       可选   班级类型
     * nO         可选   班级编号(模糊匹配)
     * name       可选   班级名称(模糊匹配)
     * grade      可选   年级代码
     * major      可选   专业代码
     * camId      可选   校区Id
     * depId      可选   学部Id
     * masterId   可选   班主任Id
     * state      可选   记录状态 1草稿、2正常、3关闭、4历史
	 * setStu     可选   名单维护 2任教老师、3高级用户、4关闭维护
     * order      可选   按“班级编号”排序：1从小到大、2从大到小
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[Clazz]}
     *
     */

    //==================================================================================================================
    // 查询2 -- 详细信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2 -- 详细信息
     * 使用者：无限制
     *
     * URL：public/cla!query.action
     *
     * 参数：
     * start       可选   记录开始位置
     * limit       可选   获取记录数量
     * autoId      可选   班级Id
     * type        可选   班级类型
     * nO          可选   班级编号(模糊匹配)
     * name        可选   班级名称(模糊匹配)
     * grade       可选   年级代码
     * major       可选   专业代码
     * camId       可选   校区Id
     * depId       可选   学部Id
     * masterId    可选   班主任Id
     * state       可选   记录状态 1草稿、2正常、3关闭、4历史
	 * setStu      可选   名单维护 2任教老师、3高级用户、4关闭维护
     * camName     可选   校区名称(模糊匹配)
     * depName     可选   部门名称(模糊匹配)
     * romName     可选   教室名称(模糊匹配)
     * thrName     可选   教师名称(模糊匹配)
     * order       可选   按“班级编号”排序：1从小到大、2从大到小
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_ClassExt.jsonOut]}
     *
     */

    //==================================================================================================================
    // 新增
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：高级用户
     *
     * URL：public/cla!newRec.action
     *
     * 参数
     * type           必需   班级类型
     * nO             必需   班级编号
     * name           必需   班级名称
     * grade          可选   年级代码
     * major          可选   专业代码
     * camId          可选   校区Id
     * depId          可选   学部Id
     * claRomId       可选   教室Id
     * masterId       可选   班主任Id
     * boyCount       可选   男生数
     * girlCount      可选   女生数
     * startManCount  可选   入学人数
     * startResult    可选   入学成绩
     * joinDate       可选   开班日期
     * gradDate       可选   结束日期
     * inSchool       可选   是否在校
     * state          可选   班级状态
	 * setStu         可选   名单维护 2任教老师、3高级用户(默认)、4关闭维护
     * remark         可选   备注
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"data":{Clazz}}
     *
     */

    //==================================================================================================================
    // 修改
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：高级用户
     *
     * URL：public/cla!edit.action
     *
     * 参数
     * autoId         必需   班级Id
     * type           可选   班级类型
     * nO             可选   班级编号
     * name           可选   班级名称
     * grade          可选   年级代码
     * major          可选   专业代码
     * camId          可选   校区Id
     * depId          可选   学部Id
     * claRomId       可选   教室Id
     * masterId       可选   班主任Id
     * boyCount       可选   男生数
     * girlCount      可选   女生数
     * startManCount  可选   入学人数
     * startResult    可选   入学成绩
     * joinDate       可选   开班日期
     * gradDate       可选   结束日期
     * inSchool       可选   是否在校
     * state          可选   班级状态
	 * setStu         可选   名单维护 2任教老师、3高级用户、4关闭维护
     * remark         可选   备注
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

	//==================================================================================================================
	// 修改记录状态
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：修改记录状态
	 * 使用者：
	 *
	 * URL：public/cla!chState.action
	 *
	 * 参数
	 * autoIds   必需   班级Id 多个用“,”隔开
	 * state    必需   状态值
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 删除
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：删除
	 * 使用者：
	 *
	 * URL：public/cla!del.action
	 *
	 * 参数
	 * autoIds   必需   班级Id 多个用“,”隔开
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

    //==================================================================================================================
