
/** 用户信息 */

    /** 教师信息 */ public V_Teacher        teacher  = null;
    /** 身份角色 */ public HashSet<Integer> thrRoles = null;
    /** 权限列表 */ public HashSet<Integer> thrPow   = null;

    /** Session  */ public HttpSession session = null;
    /** 登录IP   */ public String      IP      = null;
    /** 登录时间 */ public Timestamp   logTS   = null;

    /** 教师：超级管理员 */ public boolean isSadmin = false;
    /** 教师：管理员     */ public boolean isAdmin  = false;
    /** 教师：高级用户   */ public boolean isSuper  = false;
    /** 教师：普通用户   */ public boolean isCommon = false;
    /** 学生：           */ public boolean isStu    = false;

    /** 学生信息 */ public V_Student student = null;
