/** 班级学生 */

    /** 班级Id       */ private Integer claId     ;
    /** 学生Id       */ private Integer stuId     ;
    /** 学生入班日期 */ private Date    joinDate  ;
    /** 学生离班日期 */ private Date    leaveDate ;
    /** 备注         */ private String  remark    ;
    /** 学生状态     */ private Byte    stuState  ; //2正常(默认)、3离开
    /** 班级类型     */ private Byte    claType   ;
    /** 班级编号     */ private String  claNO     ;
    /** 班级名称     */ private String  claName   ;
    /** 班级年级     */ private Integer claGrade  ;
    /** 班级专业     */ private Integer claMajor  ;
    /** 班级校区     */ private Integer claCamId  ;
    /** 班级学部     */ private Integer claDepId  ;
    /** 班级状态     */ private Byte    claState  ;
    /** 班级名单维护 */ private Byte    claSetStu ;
    /** 班级校区名称 */ private String  claCamName;
    /** 班级学部名称 */ private String  claDepName;
    /** 学号         */ private String  stuNO     ;
    /** 学生姓名     */ private String  stuName   ;
    /** 学生性别     */ private String  stuSex    ;

    /** 按班级名称排序 */ private Byte orderC;
    /** 按学生姓名排序 */ private Byte orderS;

    //==================================================================================================================
    // 查询2 -- 详细信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2 -- 详细信息
     * 使用者：无限制
     *
     * URL：public/claStu!query2.action
     *
     * 参数：
     * start       可选   记录开始位置
     * limit       可选   获取记录数量
     * claId       可选   班级Id
     * stuId       可选   学生Id
     * stuState    可选   学生状态：2正常、3离开
     * claType     可选   班级类型
     * claNO       可选   班级编号(模糊匹配)
     * claName     可选   班级名称(模糊匹配)
     * claGrade    可选   班级年级
     * claMajor    可选   班级专业
     * claCamId    可选   班级校区
     * claDepId    可选   班级学部
     * claState    可选   班级状态
     * claSetStu   可选   班级名单维护
     * claCamName  可选   班级校区名称(模糊匹配)
     * claDepName  可选   班级学部名称(模糊匹配)
     * stuNO       可选   学生编号(模糊匹配)
     * stuName     可选   学生姓名(模糊匹配)
     * stuSex      可选   学生性别
     * orderC      可选   按班级名称排序：1从小到大、2从大到小
     * orderS      可选   按学生姓名排序：1从小到大、2从大到小
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_ClaStuExt.jsonOut]}
     *
     */

    //==================================================================================================================
    // 新增
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：高级用户,普能教师(自己任课 或 当班主任的班级)
     *
     * URL：public/claStu!newRec.action
     *
     * 参数：
     * claId      必需   班级Id
     * stuId      必需   学生Id
     * joinDate   可选   入班日期
     * leaveDate  可选   离班日期
     * remark     可选   备注信息
     * stuState   可选   学生状态：2正常(默认)、3离开
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,message:"成功信息"}
     *
     */

    //==================================================================================================================
    // 修改
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：修改
     * 使用者：高级用户,普能教师(自己任课 或 当班主任的班级)
     *
     * URL：public/claStu!edit.action
     *
     * 参数：
     * claId      必需   班级Id
     * stuId      必需   学生Id
     * joinDate   可选   入班日期
     * leaveDate  可选   离班日期
     * remark     可选   备注信息
     * stuState   可选   学生状态：2正常、3离开
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
     * 使用者：高级用户,普能教师(自己任课 或 当班主任的班级)
     *
     * URL：public/claStu!chState.action
     *
     * 参数：
     * claId     必需   班级Id
     * stuId     必需   学生Id
     * stuState  必需   学生状态：2正常、3离开
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"状态修改成功！"}
     *
     */

    //==================================================================================================================
    //删除
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：删除
     * 使用者：高级用户,普能教师(自己任课 或 当班主任的班级)
     *
     * URL：public/claStu!del.action
     *
     * 参数：
     * claId    必需   班级Id
     * stuId    必需   学生Id
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"删除成功"}
     *
     */

    //==================================================================================================================
