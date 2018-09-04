/** 考生信息 */

    /** 考试任务Id */ private Integer taskId    ;
    /** 学生Id     */ private Integer stuId     ;
    /** 考试班Id   */ private Integer examClaId ;
    /** 座位编号   */ private String  seatNO    ;
    /** 学生学号   */ private String  stuNO     ;
    /** 学生姓名   */ private String  stuName   ;
    /** 性别       */ private String  stuSex    ;
    /** 考试批次Id */ private Integer batId     ;
    /** 课程Id     */ private Integer couId     ;
    /** 班级Id     */ private Integer claId     ;
    /** 课程编号   */ private String  couNO     ;
    /** 课程名称   */ private String  couName   ;
    /** 班级类型   */ private Byte    claType   ;
    /** 班级编号   */ private String  claNO     ;
    /** 班级名称   */ private String  claName   ;
    /** 年级代码   */ private Integer grade     ;
    /** 专业代码   */ private Integer major     ;
    /** 校区Id     */ private Integer camId     ;
    /** 学部Id     */ private Integer depId     ;
    /** 考试班名称 */ private String  exmClaName;

    /** 排序字段 */ private String[] orderFd; //排序字段的名称，倒序前面加“@”，可以多个

    //==================================================================================================================
    // 查询
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询
     * 使用者：
     *
     * URL：examStu!query.action
     *
     * 参数
     * start      可选   记录开始位置
     * limit      可选   获取记录数量
     * taskId     可选   考试任务Id
     * stuId      可选   学生Id
     * examClaId  可选   考试班Id
     * seatNO     可选   座位编号
     * orderFd    可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[ExamStu]}
     *
     */

    //==================================================================================================================
    // 查询2 -- 详细信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2 -- 详细信息
     * 使用者：教师
     *
     * URL：examStu!query2.action
     *
     * 参数
     * start       可选   记录开始位置
     * limit       可选   获取记录数量
     * taskId      可选   考试任务Id
     * stuId       可选   学生Id
     * examClaId   可选   考试班Id
     * seatNO      可选   座位编号
     * stuNO       可选   学生学号
     * stuName     可选   学生姓名
     * stuSex      可选   性别
     * batId       可选   考试批次Id
     * couId       可选   课程Id
     * claId       可选   班级Id
     * couNO       可选   课程编号
     * couName     可选   课程名称
     * claType     可选   班级类型
     * claNO       可选   班级编号
     * claName     可选   班级名称
     * grade       可选   年级代码
     * major       可选   专业代码
     * camId       可选   校区Id
     * depId       可选   学部Id
     * exmClaName  可选   考试班名称
     * orderFd     可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_ExamStu]}
     *
     */

    //==================================================================================================================
    // 新增
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：教师
     *
     * URL：examStu!newRec.action
     *
     * 参数
     * taskId     必需   考试任务Id
     * stuId      必需   学生Id
     * examClaId  可选   考试班Id
     * seatNO     可选   座位编号
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"data":{ExamStu}}
     *
     */

    //==================================================================================================================
    // 修改
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：修改
     * 使用者：教师
     *
     * URL：examStu!edit.action
     *
     * 参数
     * taskId     必需   考试任务Id
     * stuId      必需   学生Id
     * examClaId  可选   考试班Id
     * seatNO     可选   座位编号
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
     * URL：examStu!del.action
     *
     * 参数
     * taskId     必需   考试任务Id
     * stuId      必需   学生Id
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
