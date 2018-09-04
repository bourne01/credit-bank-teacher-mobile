/** 学生信息 */

    /**学生Id        */ private Integer   id                    ;
    /**学号          */ private String    uid                   ;
    /**密码          */ private String    password              ;
    /**姓名          */ private String    name                  ;
    /**学部编号      */ private Integer   department_id         ;
    /**人员状态编号  */ private Integer   status_id             ; //T_Code.F_Type=1015
    /**学分          */ private Double    credit                ;
    /**学生类型编号  */ private Integer   student_kind_id       ; //T_Code.F_Type=1014
    /**特长          */ private String    specialties           ;
    /**年级编号      */ private Integer   grade_id              ; //T_Code.F_Type=35
    /**专业编号      */ private Integer   major_id              ; //T_Code.F_Type=3
    /**班级编号      */ private Integer   school_class_id       ;
    /**宿舍编号      */ private Integer   dormitory_id          ;
    /**是否在籍      */ private Byte      registered            ; //1是(默认)、2否
    /**是否在校      */ private Byte      in_school             ; //1是(默认)、2否
    /**是否学生会干部*/ private Byte      is_student_cadre      ; //1是(默认)、2否
    /**是否实习      */ private Byte      is_intern             ; //1是(默认)、2否
    /**是否住校      */ private Byte      in_residence          ; //1是(默认)、2否
    /**入学前学校    */ private String    previous_school       ;
    /**入学学部编号  */ private Integer   entrance_department_id;
    /**入学成绩      */ private Double    entrance_score        ;
    /**亲属移动电话2 */ private String    extra_phone_number    ;
    /**校园一卡通账号*/ private String    school_card_account   ;
    /**性别          */ private String    gender                ;
    /**出生日期      */ private Timestamp birth_date            ;
    /**证件类型编号  */ private Integer   credential_type_id    ; //T_Code.F_Type=1003
    /**证件号码      */ private String    credential_number     ;
    /**民族编号      */ private Integer   nation_id             ; //T_Code.F_Type=1018
    /**政治面貌编号  */ private Integer   political_status_id   ; //T_Code.F_Type=1002
    /**健康状况编号  */ private Integer   health_condition_id   ; //T_Code.F_Type=1019
    /**籍贯编号      */ private Integer   birth_place_id        ; //T_Code.F_Type=1016
    /**银行卡号      */ private String    bank_card_account     ;
    /**家庭住址      */ private String    home_address          ;
    /**移动电话      */ private String    phone_number          ;
    /**住宅电话      */ private String    landline              ;
    /**亲属移动电话  */ private String    relative_phone_number ;
    /**邮箱          */ private String    mail                  ;
    /**备注          */ private String    remark                ;
    /**学生状态      */ private Byte      state                 ; //未定义

    /** 排序   */ private Byte   order;
    /** 旧密码 */ private String oldPsw;
    /** 新密码 */ private String newPsw;

    //==================================================================================================================
    // 查询：基本信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询 -- 基本信息
     * 使用者：普通教师
     *
     * URL：public/stu!query.action
     *
     * 参数：
     * start            可选   记录开始位置
     * limit            可选   获取记录数量
     * department_id    可选   部门Id
     * id               可选   学生Id
     * uid              可选   学号(模糊匹配)
     * name             可选   姓名(模糊匹配)
     * gender           可选   性别
     * registered       可选   是否在籍 1是、2否
     * in_school        可选   是否在校 1是、2否
     * grade_id         可选   年级编号
     * major_id         可选   专业编号
     * previous_school  可选   入学前学校
     * order            可选   按“学号”排序：默认不排序、1=从小到大、2=从大到小
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[Student]}
     *
     */

    //==================================================================================================================
    // 查询2：详细信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2 -- 详细信息
     * 使用者：普通教师
     *
     * URL：public/stu!query2.action
     *
     * 参数：
     * start            可选   记录开始位置
     * limit            可选   获取记录数量
     * department_id    可选   部门Id
     * id               可选   学生Id
     * uid              可选   学号(模糊匹配)
     * name             可选   姓名(模糊匹配)
     * gender           可选   性别
     * registered       可选   是否在籍 1是、2否
     * in_school        可选   是否在校 1是、2否
     * grade_id         可选   年级编号
     * major_id         可选   专业编号
     * previous_school  可选   入学前学校
     * order            可选   按“学号”排序：默认不排序、1=从小到大、2=从大到小
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_StudentExt]}
     *
     */

    //==================================================================================================================
    // 修改
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：修改
     * 使用者：教师
     *
     * URL：public/stu!edit.action
     *
     * 参数：
     * id                      必需       学生Id         Integer
     * uid                     可选   1   学号           String
     * name                    可选   2   姓名           String
     * department_id           可选   3   学部编号       Integer
     * status_id               可选   4   人员状态编号   Integer   T_Code.F_Type=1015
     * credit                  可选   5   学分           Double
     * student_kind_id         可选   6   学生类型编号   Integer   T_Code.F_Type=1014
     * specialties             可选   7   特长           String
     * grade_id                可选   8   年级编号       Integer   T_Code.F_Type=35
     * major_id                可选   9   专业编号       Integer   T_Code.F_Type=3
     * school_class_id         可选  10   班级编号       Integer
     * dormitory_id            可选  11   宿舍编号       Integer
     * registered              可选  12   是否在籍       Byte      1是、2否
     * in_school               可选  13   是否在校       Byte      1是、2否
     * is_student_cadre        可选  14   是否学生会干部 Byte      1是、2否
     * is_intern               可选  15   是否实习       Byte      1是、2否
     * in_residence            可选  16   是否住校       Byte      1是、2否
     * previous_school         可选  17   入学前学校     String
     * entrance_department_id  可选  18   入学学部编号   Integer
     * entrance_score          可选  19   入学成绩       Double
     * extra_phone_number      可选  20   亲属移动电话2  String
     * school_card_account     可选  21   校园一卡通账号 String
     * gender                  可选  22   性别           String
     * birth_date              可选  23   出生日期       Timestamp
     * credential_type_id      可选  24   证件类型编号   Integer   T_Code.F_Type=1003
     * credential_number       可选  25   证件号码       String
     * nation_id               可选  26   民族编号       Integer   T_Code.F_Type=1018
     * political_status_id     可选  27   政治面貌编号   Integer   T_Code.F_Type=1002
     * health_condition_id     可选  28   健康状况编号   Integer   T_Code.F_Type=1019
     * birth_place_id          可选  29   籍贯编号       Integer   T_Code.F_Type=1016
     * bank_card_account       可选  30   银行卡号       String
     * home_address            可选  31   家庭住址       String
     * phone_number            可选  32   移动电话       String
     * landline                可选  33   住宅电话       String
     * relative_phone_number   可选  34   亲属移动电话   String
     * mail                    可选  35   邮箱           String
     * remark                  可选  36   备注           String
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
    // 修改个人密码
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：修改个人密码
     * 使用者：学生
     *
     * URL：public/stu!modifyPsw.action
     *
     * 参数：
     * oldPsw    必需   旧密码
     * newPsw    必需   新密码
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"密码修改成功！"}
     *
     */

    //==================================================================================================================
    // 重置密码
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：重置密码
     * 使用者：高级用户
     *
     * URL：public/stu!resetPsw.action
     *
     * 参数：
     * newPsw    可选   新密码，没有指定默认是123456
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"密码重置成功！"}
     *
     */

    //==================================================================================================================
    // 修改记录状态
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：修改记录状态
     * 使用者：教师
     *
     * URL：public/stu!chState.action
     *
     * 参数：
     * id       必需   学生Id
     * state    必需   新状态
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"状态修改成功！"}
     *
     */

    //==================================================================================================================
    // 本地学生登录
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     * 功能：本地学生登录
     *
     * URL：public/stu!login.action
     *
     * 参数：
     * uid        必需   学号
     * password   必需   密码
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"data":{V_Studnet}}
     *
     * 说明：无论是否登录成功，当前已登录的账号都会被注销
     *
     */

    //==================================================================================================================
