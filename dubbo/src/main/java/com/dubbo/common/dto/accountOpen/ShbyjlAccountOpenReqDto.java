package com.dubbo.common.dto.accountOpen;



import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 上海易精灵开户入参Dto
 * Created by BF100177 on 2017/1/19.
 */
public class ShbyjlAccountOpenReqDto implements Serializable{

    private String userId;//漫道内部用户ID

    private String gBName;//英文客户全称(英文企业全称),如果客户没有英文名称,请填写"没有中文名称"

    private String cNName;//中文客户全称(中文企业全称),如果客户没有中文名称,请填写"没有中文名称"

    private String idNo;//证件号码(组织机构代码)

    private String custType;//客户类别,4位客户类别编码(参看枚举值客户类别)

    private String trdCode;//行业代码,4位行业代码编码(参看枚举值行业代码)

    private String regId;//注册登记号(工商注册号)

    private String limitDate;//注册期限(YYYYMMDD)

    private String corpName;//法人代表姓名

    private String legPerId;//法定代表人证件号(身份证号码)

    private String corpIdCardLimitDate;//法人证件到期日(YYYYMMDD)

    private String legalPhone;//法人代表联系电话

    private String cfoName;//财务主管姓名

    private String telephone;//财务主管电话

    private BigDecimal capReg;//注册资本

    private String medSmEntFlg;//企业规模(L:大型/M:中型/S:小型/T:微型)

    private String regDist;//省市区街道代码(参看枚举值省市区街道代码)

    private String regStrentDoor;//街道地址（具体到门牌号）

    private String regTePhone;//注册地址电话号码

    private String acctBank;//绑定卡清算行行号(参看枚举值绑定卡清算行行号)

    private String account;//绑定银行对公账号

    private String depType;//存款人类别(01 - 企业法人,02 - 非法人企业)

    private String regType;//注册类型(A - 企业法人营业执照（企业法人）,B - 企业营业执照（非企业法人）,C - 个体工商执照, D - 民办非企业登记证书)

    private String docuOpName;//制单员姓名(需要创建的制单员的姓名)

    private String docuOpMobile;//制单员手机号

    private String docuOpIdCard;//制单员身份证号码

    private String checkerName;//复核员姓名(需要创建的复核员的姓名)

    private String checkerMobile;//复核员手机号

    private String checkerIdCard;//复核员身份证号码

    private String picQyyyzz;//企业营业执照图片(ChannelID-日期-组织机构代码-1.jpg)

    private String picZzjgdmz;//组织机构代码证图片(ChannelID-日期-组织机构代码-2.jpg)

    private String picFrSfzZm;//法人身份证正面图片(ChannelID-日期-组织机构代码-3.jpg)

    private String picFrSfzFm;//法人身份证反面图片(ChannelID-日期-组织机构代码-4.jpg)

    private String picSqrSfzZm;//申请人身份证正面图片(ChannelID-日期-组织机构代码-5.jpg)

    private String picSqrSfzFm;//申请人身份证反面图片(ChannelID-日期-组织机构代码-6.jpg)

    private String picZdySfzZm;//制单员身份证正面图片(ChannelID-日期-组织机构代码-7.jpg)

    private String picZdySfzFm;//制单员身份证反面图片(ChannelID-日期-组织机构代码-8.jpg)
    private String picShySfzZm;//审核员身份证正面图片(ChannelID-日期-组织机构代码-9.jpg)

    private String picShySfzFm;//审核员身份证反面图片(ChannelID-日期-组织机构代码-10.jpg)

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getgBName() {
        return gBName;
    }

    public void setgBName(String gBName) {
        this.gBName = gBName;
    }

    public String getcNName() {
        return cNName;
    }

    public void setcNName(String cNName) {
        this.cNName = cNName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getTrdCode() {
        return trdCode;
    }

    public void setTrdCode(String trdCode) {
        this.trdCode = trdCode;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(String limitDate) {
        this.limitDate = limitDate;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getLegPerId() {
        return legPerId;
    }

    public void setLegPerId(String legPerId) {
        this.legPerId = legPerId;
    }

    public String getCorpIdCardLimitDate() {
        return corpIdCardLimitDate;
    }

    public void setCorpIdCardLimitDate(String corpIdCardLimitDate) {
        this.corpIdCardLimitDate = corpIdCardLimitDate;
    }

    public String getLegalPhone() {
        return legalPhone;
    }

    public void setLegalPhone(String legalPhone) {
        this.legalPhone = legalPhone;
    }

    public String getCfoName() {
        return cfoName;
    }

    public void setCfoName(String cfoName) {
        this.cfoName = cfoName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public BigDecimal getCapReg() {
        return capReg;
    }

    public void setCapReg(BigDecimal capReg) {
        this.capReg = capReg;
    }

    public String getMedSmEntFlg() {
        return medSmEntFlg;
    }

    public void setMedSmEntFlg(String medSmEntFlg) {
        this.medSmEntFlg = medSmEntFlg;
    }

    public String getRegDist() {
        return regDist;
    }

    public void setRegDist(String regDist) {
        this.regDist = regDist;
    }

    public String getRegStrentDoor() {
        return regStrentDoor;
    }

    public void setRegStrentDoor(String regStrentDoor) {
        this.regStrentDoor = regStrentDoor;
    }

    public String getRegTePhone() {
        return regTePhone;
    }

    public void setRegTePhone(String regTePhone) {
        this.regTePhone = regTePhone;
    }

    public String getAcctBank() {
        return acctBank;
    }

    public void setAcctBank(String acctBank) {
        this.acctBank = acctBank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDepType() {
        return depType;
    }

    public void setDepType(String depType) {
        this.depType = depType;
    }

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }

    public String getDocuOpName() {
        return docuOpName;
    }

    public void setDocuOpName(String docuOpName) {
        this.docuOpName = docuOpName;
    }

    public String getDocuOpMobile() {
        return docuOpMobile;
    }

    public void setDocuOpMobile(String docuOpMobile) {
        this.docuOpMobile = docuOpMobile;
    }

    public String getDocuOpIdCard() {
        return docuOpIdCard;
    }

    public void setDocuOpIdCard(String docuOpIdCard) {
        this.docuOpIdCard = docuOpIdCard;
    }

    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    public String getCheckerMobile() {
        return checkerMobile;
    }

    public void setCheckerMobile(String checkerMobile) {
        this.checkerMobile = checkerMobile;
    }

    public String getCheckerIdCard() {
        return checkerIdCard;
    }

    public void setCheckerIdCard(String checkerIdCard) {
        this.checkerIdCard = checkerIdCard;
    }

    public String getPicQyyyzz() {
        return picQyyyzz;
    }

    public void setPicQyyyzz(String picQyyyzz) {
        this.picQyyyzz = picQyyyzz;
    }

    public String getPicZzjgdmz() {
        return picZzjgdmz;
    }

    public void setPicZzjgdmz(String picZzjgdmz) {
        this.picZzjgdmz = picZzjgdmz;
    }

    public String getPicFrSfzZm() {
        return picFrSfzZm;
    }

    public void setPicFrSfzZm(String picFrSfzZm) {
        this.picFrSfzZm = picFrSfzZm;
    }

    public String getPicFrSfzFm() {
        return picFrSfzFm;
    }

    public void setPicFrSfzFm(String picFrSfzFm) {
        this.picFrSfzFm = picFrSfzFm;
    }

    public String getPicSqrSfzZm() {
        return picSqrSfzZm;
    }

    public void setPicSqrSfzZm(String picSqrSfzZm) {
        this.picSqrSfzZm = picSqrSfzZm;
    }

    public String getPicSqrSfzFm() {
        return picSqrSfzFm;
    }

    public void setPicSqrSfzFm(String picSqrSfzFm) {
        this.picSqrSfzFm = picSqrSfzFm;
    }

    public String getPicZdySfzZm() {
        return picZdySfzZm;
    }

    public void setPicZdySfzZm(String picZdySfzZm) {
        this.picZdySfzZm = picZdySfzZm;
    }

    public String getPicZdySfzFm() {
        return picZdySfzFm;
    }

    public void setPicZdySfzFm(String picZdySfzFm) {
        this.picZdySfzFm = picZdySfzFm;
    }

    public String getPicShySfzZm() {
        return picShySfzZm;
    }

    public void setPicShySfzZm(String picShySfzZm) {
        this.picShySfzZm = picShySfzZm;
    }

    public String getPicShySfzFm() {
        return picShySfzFm;
    }

    public void setPicShySfzFm(String picShySfzFm) {
        this.picShySfzFm = picShySfzFm;
    }
}
