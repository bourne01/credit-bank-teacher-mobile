/** 考试任务关联任课 */

    /** 考试任务Id */ private Integer taskId      ;
    /** 关联任课Id */ private Integer thrCouId    ;
    /** 学期Id     */ private Integer termId      ;
    /** 教师Id     */ private Integer thrId       ;
    /** 课程Id     */ private Integer couId       ;
    /** 班级Id     */ private Integer claId       ;
    /** 场地Id     */ private Integer romId       ;
    /** 开课类型   */ private Integer couType     ; //T_Code.F_Type=11
    /** 学期名称   */ private String  termName    ;
    /** 教师编号   */ private String  thrNO       ;
    /** 教师姓名   */ private String  thrName     ;
    /** 教师性别   */ private String  thrSex      ;
    /** 课程编号   */ private String  couNO       ;
    /** 课程名称   */ private String  couName     ;
    /** 班级类型   */ private Byte    claType     ;
    /** 班级编号   */ private String  claNO       ;
    /** 班级名称   */ private String  claName     ;
    /** 年级代码   */ private Integer grade       ;
    /** 专业代码   */ private Integer major       ;
    /** 校区Id     */ private Integer camId       ;
    /** 学部Id     */ private Integer depId       ;
    /** 场地编号   */ private String  romNO       ;
    /** 场地名称   */ private String  romName     ;

    /** 排序字段 */ private String[] orderFd; //排序字段的名称，倒序前面加“@”，可以多个

    //==================================================================================================================
    // 查询
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询
     * 使用者：
     *
     * URL：examTaskThrCou!query.action
     *
     * 参数
     * start     可选   记录开始位置
     * limit     可选   获取记录数量
     * taskId    可选   考试任务Id
     * thrCouId  可选   关联任课Id
     * orderFd   可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[ExamTaskThrCou]}
     *
     */

    //==================================================================================================================
    // 查询2 -- 详细信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2 -- 详细信息
     * 使用者：教师
     *
     * URL：examTaskThrCou!query.action
     *
     * 参数
     * start         可选   记录开始位置
     * limit         可选   获取记录数量
     * taskId        可选   考试任务Id
     * thrCouId      可选   关联任课Id
     * termId        可选   学期Id
     * thrId         可选   教师Id
     * couId         可选   课程Id
     * claId         可选   班级Id
     * romId         可选   场地Id
     * couType       可选   开课类型 T_Code.F_Type=11
     * termName      可选   学期名称
     * thrNO         可选   教师编号
     * thrName       可选   教师姓名
     * thrSex        可选   教师性别
     * couNO         可选   课程编号
     * couName       可选   课程名称
     * claType       可选   班级类型
     * claNO         可选   班级编号
     * claName       可选   班级名称
     * grade         可选   年级代码
     * major         可选   专业代码
     * camId         可选   校区Id
     * depId         可选   学部Id
     * romNO         可选   场地编号
     * romName       可选   场地名称
     * orderFd       可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_ExamTaskThrCou]}
     *
     */

    //==================================================================================================================
    // 新增
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：教师
     *
     * URL：examTaskThrCou!newRec.action
     *
     * 参数
     * taskId    必需   考试任务Id
     * thrCouId  必需   关联任课Id
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
     * 使用者：教师
     *
     * URL：examTaskThrCou!del.action
     *
     * 参数
     * taskId    必需   考试任务Id
     * thrCouId  必需   关联任课Id
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
