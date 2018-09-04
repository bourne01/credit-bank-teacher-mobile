/** 指定考场 -- 教学班 */

    /** 考试批次Id */ private Integer batId     ;
    /** 考试时段Id */ private Integer claId     ;
    /** 考场Id     */ private Integer exmRomId  ;
    /** 班级类型   */ private Byte    claType   ;
    /** 班级编号   */ private String  claNO     ;
    /** 班级名称   */ private String  claName   ;
    /** 年级代码   */ private Integer grade     ;
    /** 专业代码   */ private Integer major     ;
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
     * URL：claExmRom!query.action
     *
     * 参数
     * start     可选   记录开始位置
     * limit     可选   获取记录数量
     * batId     可选   考试批次Id
     * claId     可选   考试时段Id
     * exmRomId  可选   考场Id
     * orderFd   可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[ClaExamRoom]}
     *
     */

    //==================================================================================================================
    // 查询2 -- 详细信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2 -- 详细信息
     * 使用者：教师
     *
     * URL：claExmRom!query.action
     *
     * 参数
     * start       可选   记录开始位置
     * limit       可选   获取记录数量
     * batId       可选   考试批次Id
     * claId       可选   考试时段Id
     * exmRomId    可选   考场Id
     * claType     可选   班级类型
     * claNO       可选   班级编号
     * claName     可选   班级名称
     * grade       可选   年级代码
     * major       可选   专业代码
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
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_ClaExamRoom2]}
     *
     */

    //==================================================================================================================
    // 新增
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：高级用户
     *
     * URL：claExmRom!newRec.action
     *
     * 参数
     * batId     必需   考试批次Id
     * claId     必需   考试时段Id
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
     * URL：claExmRom!del.action
     *
     * 参数
     * batId     必需   考试批次Id
     * claId     必需   考试时段Id
     * exmRomId  必需   考场Id
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
