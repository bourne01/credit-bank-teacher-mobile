/** 指定考场 -- 考试班 */

    /** 考试班Id   */ private Integer exmClaId  ;
    /** 考场Id     */ private Integer exmRomId  ;
    /** 考试批次Id */ private Integer batId     ;
    /** 考试任务Id */ private Integer taskId    ;
    /** 考试班名称 */ private String  exmClaName;
    /** 绑定行政班 */ private Integer claId     ; //默认0表示不绑定，大于0为行政班Id
    /** 考生人数   */ private Short   examStuNum;
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
     * URL：exmClaExmRom!query.action
     *
     * 参数
     * start     可选   记录开始位置
     * limit     可选   获取记录数量
     * exmClaId  可选   考试班Id
     * exmRomId  可选   考场Id
     * orderFd   可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[ExamClaExamRoom]}
     *
     */

    //==================================================================================================================
    // 查询2 -- 详细数据
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2 -- 详细数据
     * 使用者：教师
     *
     * URL：exmClaExmRom!query2.action
     *
     * 参数
     * start       可选   记录开始位置
     * limit       可选   获取记录数量
     * exmClaId    可选   考试班Id
     * exmRomId    可选   考场Id
     * batId       可选   考试批次Id
     * taskId      可选   考试任务Id
     * exmClaName  可选   考试班名称
     * claId       可选   绑定行政班 默认0表示不绑定，大于0为行政班Id
     * examStuNum  可选   考生人数
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
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_ExamClaExamRoom2]}
     *
     */

    //==================================================================================================================
    // 新增
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：高级用户
     *
     * URL：exmClaExmRom!newRec.action
     *
     * 参数
     * exmClaId  必需   考试班Id
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
     * URL：exmClaExmRom!del.action
     *
     * 参数
     * exmClaId  必需   考试班Id
     * exmRomId  必需   考场Id
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
