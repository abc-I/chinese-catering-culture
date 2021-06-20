package org.bearer.entity.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/4/22 16:12
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenIdJson implements Serializable {

    private static final long serialVersionUID = 2415988306266110348L;

    @JsonProperty("openid")
    private String openId;

    @JsonProperty("session_key")
    private String sessionKey;

    @JsonProperty("unionid")
    private String unionId;

    @JsonProperty("errcode")
    private Integer errCode;

    @JsonProperty("errmsg")
    private String errMsg;
}
