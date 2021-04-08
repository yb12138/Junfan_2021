/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.geekidea.springbootplus.framework.common.api;

/**
 * <p>
 * REST API 响应码
 * </p>
 *
 * @author geekidea
 * @since 2018-11-08
 */
public enum ApiCode {

    /**
     * 操作成功
     **/
    SUCCESS(200, "操作成功"),
    /**
     * 非法访问
     **/
    UNAUTHORIZED(401, "非法访问"),
    /**
     * 没有权限
     **/
    NOT_PERMISSION(403, "没有权限"),
    /**
     * 你请求的资源不存在
     **/
    NOT_FOUND(404, "你请求的资源不存在"),
    /**
     * 操作失败
     **/
    FAIL(500, "操作失败"),
    /**
     * 登录失败
     **/
    LOGIN_EXCEPTION(4000, "登录失败"),
    /**
     * 系统异常
     **/
    SYSTEM_EXCEPTION(5000, "系统异常"),
    /**
     * 请求参数校验异常
     **/
    PARAMETER_EXCEPTION(5001, "请求参数校验异常"),
    /**
     * 请求参数解析异常
     **/
    PARAMETER_PARSE_EXCEPTION(5002, "请求参数解析异常"),
    /**
     * HTTP内容类型异常
     **/
    HTTP_MEDIA_TYPE_EXCEPTION(5003, "HTTP内容类型异常"),
    /**
     * 系统处理异常
     **/
    SPRING_BOOT_PLUS_EXCEPTION(5100, "系统处理异常"),
    /**
     * 业务处理异常
     **/
    BUSINESS_EXCEPTION(5101, "业务处理异常"),
    /**
     * 数据库处理异常
     **/
    DAO_EXCEPTION(5102, "数据库处理异常"),
    /**
     * 验证码校验异常
     **/
    VERIFICATION_CODE_EXCEPTION(5103, "验证码校验异常"),
    /**
     * 登录授权异常
     **/
    AUTHENTICATION_EXCEPTION(5104, "登录授权异常"),
    /**
     * 没有访问权限
     **/
    UNAUTHENTICATED_EXCEPTION(5105, "没有访问权限"),
    /**
     * 没有访问权限
     **/
    UNAUTHORIZED_EXCEPTION(5106, "没有访问权限"),
    /**
     * JWT Token解析异常
     **/
    JWTDECODE_EXCEPTION(5107, "Token解析异常"),

    HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION(5108, "METHOD NOT SUPPORTED"),
    E_400(400, "请求处理异常，请稍后再试"),
    E_500(500, "请求方式有误,请检查 GET/POST"),
    E_501(501, "请求路径不存在"),
    E_502(502, "权限不足"),
    E_10008(10008, "角色删除失败,尚有用户属于此角色"),
    E_10009(10009, "账户已存在"),
    E_10010(10010, "库存异常，审核失败"),
    E_20011(20011, "登陆已过期,请重新登陆"),
    E_100001(100001, "无法找到采购单"),
    E_100002(100002, "该入库单已审核通过，无法删除"),
    E_100003(100003, "该采购单财务尚未通过，无法入库"),
    E_100004(100004, "该采购单入库已完成"),
    E_100005(100005, "出库数量超过库存数目"),
    E_100006(100006, "该供应商已存在"),
    E_100007(100007, "产品删除失败，该产品尚有采购记录"),
    E_100008(100008, "产品删除失败，该产品尚有入库记录"),
    E_100009(100009, "存在不是待提交状态的采购单"),
    E_100010(100010, "供应商删除失败，该供应商尚有对应采购单"),
    E_100011(100011, "供应商删除失败，该供应商尚有对应产品"),
    E_100012(100012, "该sku已存在"),
    E_100013(100013, "查无此货运单号"),
    E_100014(100014, "母代码删除失败，该产品尚有下属sku"),
    E_100015(100015, "导入文件为空"),
    E_100016(100016, "请选择仓库"),
    E_100017(100017, "缺少价格"),
    E_90003(90003, "缺少必填参数");
    ;

    private final int code;
    private final String message;

    ApiCode(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public static ApiCode getApiCode(int code) {
        ApiCode[] ecs = ApiCode.values();
        for (ApiCode ec : ecs) {
            if (ec.getCode() == code) {
                return ec;
            }
        }
        return SUCCESS;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
