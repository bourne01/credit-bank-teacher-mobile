/** 指定考场 -- 考试任务 */

    /** 考试任务Id */ private Integer taskId    ;
    /** 考场Id     */ private Integer exmRomId  ;
    /** 考试批次Id */ private Integer batId     ;
    /** 课程Id     */ private Integer couId     ;
    /** 班级Id     */ private Integer claId     ;
    /** 拆班系数   */ private Byte    split     ; //就是考试时，学生要拆分到不同考场考试，默认1(不拆分)
    /** 考生人数   */ private Short   examStuNum;
    /** 考卷Id     */ private Integer paperId   ;
    /** 记录状态   */ private Byte    taskState ; // 2正常(默认)、3关闭、4历史
    /** 课程编号   */ private String  couNO     ;
    /** 课程名称   */ private String  couName   ;
    /** 班级编号   */ private String  claNO     ;
    /** 班级名称   */ private String  claName   ;
    /** 年级代码   */ private Integer grade     ; //代码类型(35)
    /** 专业代码   */ private Integer major     ; //代码类型(3)
    /** 校区Id     */ private Integer camId     ;
    /** 学部Id     */ private Integer depId     ;
    /** 场地Id     */ private Integer claRomId  ;
    /** 座位数量   */ private Short   seatNum   ;
    /** 并班系数   */ private Byte    merge     ; //1不允许并班(默认)，大于2为最多允许几个班，最大99
    /** 场地编号   */ private String  claRomNO  ;
    /** 场地名称   */ private String  claRomName;
    /** 教学楼     */ private Integer buiId     ;
    /** 教学楼名称 */ private String  buiName   ;

    /** 排序字段 */ private String[] orderFd; //排序字段的名称，倒序前面加“@”，可以多个

    //==================================================================================================================
    // 查询
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询
     * 使用者：
     *
     * URL：taskExmRom!query.action
     *
     * 参数
     * start     可选   记录开始位置
     * limit     可选   获取记录数量
     * taskId    可选   考试任务Id
     * exmRomId  可选   考场Id
     * orderFd   可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[ExamTaskExamRoom]}
     *
     */

    //==================================================================================================================
    // 查询2 -- 详细数据
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2 -- 详细数据
     * 使用者：教师
     *
     * URL：taskExmRom!query2.action
     *
     * 参数
     * start       可选   记录开始位置
     * limit       可选   获取记录数量
     * taskId      可选   考试任务Id
     * exmRomId    可选   考场Id
     * batId       可选   考试批次Id
     * couId       可选   课程Id
     * claId       可选   班级Id
     * split       可选   拆班系数 就是考试时，学生要拆分到不同考场考试，默认1(不拆分)
     * examStuNum  可选   考生人数
     * paperId     可选   考卷Id
     * taskState   可选   记录状态  2正常(默认)、3关闭、4历史
     * couNO       可选   课程编号
     * couName     可选   课程名称
     * claNO       可选   班级编号
     * claName     可选   班级名称
     * grade       可选   年级代码 代码类型(35)
     * major       可选   专业代码 代码类型(3)
     * camId       可选   校区Id
     * depId       可选   学部Id
     * claRomId    可选   场地Id
     * seatNum     可选   座位数量
     * merge       可选   并班系数 1不允许并班(默认)，大于2为最多允许几个班，最大99
     * claRomNO    可选   场地编号
     * claRomName  可选   场地名称
     * buiId       可选   教学楼
     * buiName     可选   教学楼名称
     * orderFd     可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_ExamTaskExamRoom2]}
     *
     */

    //==================================================================================================================
    // 新增
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：高级用户
     *
     * URL：taskExmRom!newRec.action
     *
     * 参数
     * taskId    必需   考试任务Id
     * exmRomId  必需   考场Id
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
     * 使用者：高级用户
     *
     * URL：taskExmRom!del.action
     *
     * 参数
     * taskId    必需   考试任务Id
     * exmRomId  必需   考场Id
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
