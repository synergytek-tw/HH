-- 20200524 Tony --

UPDATE `hh`.`category` SET `Memo`='I' WHERE `FlowKey`='PN01';
UPDATE `hh`.`category` SET `Memo`='U' WHERE `FlowKey`='PN02';
UPDATE `hh`.`category` SET `Memo`='D' WHERE `FlowKey`='PN03';
INSERT INTO `hh`.`category` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `ParentId`, `CategoryFlag`, `CategoryGroup`, `SubjectId_D`, `SubjectId_C`, `Helper`, `Sponsor`, `Controler`, `Memo`, `Rate`) VALUES ('PN04', 'Demo', 'admin', '銵�身閮�', 'PatentType', '', '', '', '', '', '', '', 'DD', '1');
INSERT INTO `hh`.`category` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `ParentId`, `CategoryFlag`, `CategoryGroup`, `SubjectId_D`, `SubjectId_C`, `Helper`, `Sponsor`, `Controler`, `Memo`, `Rate`) VALUES ('PN14', 'Demo', 'admin', '�隞�', 'PatentType', '', '', '', '', '', '', '', 'O', '1');


--
ALTER TABLE  `Applicant` ADD  `EnglishAddress2` VARCHAR( 500 ) NULL ;
update Applicant set EnglishAddress2 = '';

--

delete from category where parentid='AttorneyTitle';
INSERT INTO `category` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `ParentId`, `CategoryFlag`, `CategoryGroup`, `SubjectId_D`, `SubjectId_C`, `Helper`, `Sponsor`, `Controler`, `Memo`, `Rate`) VALUES
('ATitle01', '99', 'admin', '漢法商標事務所_繁中_華南銀行', 'AttorneyTitle', 'Y', '', '', '', '', '', '', '', 1),
('ATitle02', '99', 'admin', '翰法商標事務所_繁中', 'AttorneyTitle', 'Y', '', '', '', '', '', '', '', 1),
('ATitle03', '99', 'admin', '漢華專利事務所_繁中', 'AttorneyTitle', 'Y', '', '', '', '', '', '', '', 1),
('ATitle04', '99', 'admin', '翰華商標事務所_繁中', 'AttorneyTitle', 'Y', '', '', '', '', '', '', '', 1),
('ATitle05', '99', 'admin', '揚昇企業顧問有限公司_繁中', 'AttorneyTitle', 'Y', '', '', '', '', '', '', '', 1),
('ATitle06', '99', 'admin', '翰法商标事务所_簡中', 'AttorneyTitle', 'Y', '', '', '', '', '', '', '', 1),
('ATitle07', '99', 'admin', '汉华专利事务所_簡中', 'AttorneyTitle', 'Y', '', '', '', '', '', '', '', 1),
('ATitle08', '99', 'admin', '翰华商标事务所_簡中', 'AttorneyTitle', 'Y', '', '', '', '', '', '', '', 1),
('ATitle09', '99', 'admin', '翰法商標事務所_英文', 'AttorneyTitle', 'Y', '', '', '', '', '', '', '', 1),
('ATitle10', '99', 'admin', '漢華專利事務所_英文', 'AttorneyTitle', 'Y', '', '', '', '', '', '', '', 1),
('ATitle11', '99', 'admin', '翰華商標事務所_英文', 'AttorneyTitle', 'Y', '', '', '', '', '', '', '', 1),
('ATitle12', '99', 'admin', '漢法商標事務所_繁中_新光銀行', 'AttorneyTitle', 'Y', '', '', '', '', '', '', '', 1)
;


delete from category where parentid='ATitle01';
INSERT INTO `category` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `ParentId`, `CategoryFlag`, `CategoryGroup`, `SubjectId_D`, `SubjectId_C`, `Helper`, `Sponsor`, `Controler`, `Memo`, `Rate`) VALUES
('ATitle01_Title', '99', 'admin', '漢法商標事務所', 'ATitle01', 'Y', '', '', '', '', '', '', '', 1),
('ATitle01_Subtitle1', '99', 'admin', 'HAN HWA TRADEMARK OFFICE', 'ATitle01', 'Y', '', '', '', '', '', '', '', 1),
('ATitle01_Subtitle2', '99', 'admin', 'TEL:(02)25062086  FAX:(02)25061985<br>扣繳地址：台北市中山區朱園里24鄰長安東路二段80號8樓之4<br>扣繳統一編號：17608439', 'ATitle01', 'Y', '', '', '', '', '', '', '', 1),
('ATitle01_RemittanceInfo', '99', 'admin', '銀行:華南銀行(008)_敦化分行<br>帳號: 130-10-050058-4<br>戶名:漢法商標事務所', 'ATitle01', 'Y', '', '', '', '', '', '', '', 1)
;

delete from category where parentid='ATitle12';
INSERT INTO `category` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `ParentId`, `CategoryFlag`, `CategoryGroup`, `SubjectId_D`, `SubjectId_C`, `Helper`, `Sponsor`, `Controler`, `Memo`, `Rate`) VALUES
('ATitle12_Title', '99', 'admin', '漢法商標事務所', 'ATitle12', 'Y', '', '', '', '', '', '', '', 1),
('ATitle12_Subtitle1', '99', 'admin', 'HAN HWA TRADEMARK OFFICE', 'ATitle12', 'Y', '', '', '', '', '', '', '', 1),
('ATitle12_Subtitle2', '99', 'admin', 'TEL:(02)25062086  FAX:(02)25061985<br>扣繳地址：台北市中山區朱園里24鄰長安東路二段80號8樓之4<br>扣繳統一編號：17608439', 'ATitle12', 'Y', '', '', '', '', '', '', '', 1),
('ATitle12_RemittanceInfo', '99', 'admin', '銀行:新光銀行(103)_長安分行<br>
帳號: 0611-10-100137-0<br>戶名:漢法商標事務所', 'ATitle12', 'Y', '', '', '', '', '', '', '', 1)
;

delete from category where parentid='ATitle02';
INSERT INTO `category` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `ParentId`, `CategoryFlag`, `CategoryGroup`, `SubjectId_D`, `SubjectId_C`, `Helper`, `Sponsor`, `Controler`, `Memo`, `Rate`) VALUES
('ATitle02_Title', '99', 'admin', '翰法商標事務所', 'ATitle02', 'Y', '', '', '', '', '', '', '', 1),
('ATitle02_Subtitle1', '99', 'admin', 'HAN HWA TRADEMARK OFFICE', 'ATitle02', 'Y', '', '', '', '', '', '', '', 1),
('ATitle02_Subtitle2', '99', 'admin', 'TEL:(02)25062086  FAX:(02)25061985<br>扣繳地址：台北市中山區朱園里24鄰長安東路二段80號8樓之4<br>扣繳統一編號：31971711', 'ATitle02', 'Y', '', '', '', '', '', '', '', 1),
('ATitle02_RemittanceInfo', '99', 'admin', '銀行:玉山銀行(808)_雙和分行<br>帳號:0129-940-036228<br>戶名:翰法商標事務所', 'ATitle02', 'Y', '', '', '', '', '', '', '', 1)
;

delete from category where parentid='ATitle03';
INSERT INTO `category` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `ParentId`, `CategoryFlag`, `CategoryGroup`, `SubjectId_D`, `SubjectId_C`, `Helper`, `Sponsor`, `Controler`, `Memo`, `Rate`) VALUES
('ATitle03_Title', '99', 'admin', '漢華專利事務所', 'ATitle03', 'Y', '', '', '', '', '', '', '', 1),
('ATitle03_Subtitle1', '99', 'admin', 'HAN HWA PATENT OFFICE', 'ATitle03', 'Y', '', '', '', '', '', '', '', 1),
('ATitle03_Subtitle2', '99', 'admin', 'TEL:(02)25062086  FAX:(02)25061985<br>扣繳地址：台北市中山區朱園里24鄰長安東路二段80號8樓之4<br>扣繳統一編號：25684661', 'ATitle03', 'Y', '', '', '', '', '', '', '', 1),
('ATitle03_RemittanceInfo', '99', 'admin', '銀行:新光銀行(103)_長安分行<br>帳號:0611-10-100387-9<br>戶名:漢華專利事務所', 'ATitle03', 'Y', '', '', '', '', '', '', '', 1)
;

delete from category where parentid='ATitle04';
INSERT INTO `category` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `ParentId`, `CategoryFlag`, `CategoryGroup`, `SubjectId_D`, `SubjectId_C`, `Helper`, `Sponsor`, `Controler`, `Memo`, `Rate`) VALUES
('ATitle04_Title', '99', 'admin', '翰華商標事務所', 'ATitle04', 'Y', '', '', '', '', '', '', '', 1),
('ATitle04_Subtitle1', '99', 'admin', 'HAN HWA TRADEMARK OFFICE', 'ATitle04', 'Y', '', '', '', '', '', '', '', 1),
('ATitle04_Subtitle2', '99', 'admin', 'TEL:(02)25062086  FAX:(02)25061985<br>扣繳地址：台北市中山區朱園里24鄰長安東路二段80號8樓之4<br>扣繳統一編號：31835625', 'ATitle04', 'Y', '', '', '', '', '', '', '', 1),
('ATitle04_RemittanceInfo', '99', 'admin', '銀行:華南銀行(008)_敦化分行<br>帳號:130-10-002858-8<br>戶名:翰華商標事務所', 'ATitle04', 'Y', '', '', '', '', '', '', '', 1)
;

delete from category where parentid='ATitle05';
INSERT INTO `category` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `ParentId`, `CategoryFlag`, `CategoryGroup`, `SubjectId_D`, `SubjectId_C`, `Helper`, `Sponsor`, `Controler`, `Memo`, `Rate`) VALUES
('ATitle05_Title', '99', 'admin', '揚昇企業顧問有限公司', 'ATitle05', 'Y', '', '', '', '', '', '', '', 1),
('ATitle05_Subtitle1', '99', 'admin', 'S&R IPR CONSULTING CORPORATION', 'ATitle05', 'Y', '', '', '', '', '', '', '', 1),
('ATitle05_Subtitle2', '99', 'admin', 'TEL:(02)25062086  FAX:(02)25061985<br>扣繳地址：台北市中山區朱園里24鄰長安東路二段80號8樓之4<br>扣繳統一編號：12949850', 'ATitle05', 'Y', '', '', '', '', '', '', '', 1),
('ATitle05_RemittanceInfo', '99', 'admin', '銀行:玉山銀行(808)_雙和分行<br>帳號: 0129-940-038268<br>戶名:揚昇企業顧問有限公司', 'ATitle05', 'Y', '', '', '', '', '', '', '', 1)
;

delete from category where parentid='ATitle06';
INSERT INTO `category` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `ParentId`, `CategoryFlag`, `CategoryGroup`, `SubjectId_D`, `SubjectId_C`, `Helper`, `Sponsor`, `Controler`, `Memo`, `Rate`) VALUES
('ATitle06_Title', '99', 'admin', '翰法商标事务所', 'ATitle06', 'Y', '', '', '', '', '', '', '', 1),
('ATitle06_Subtitle1', '99', 'admin', 'HAN HWA TRADEMARK OFFICE', 'ATitle06', 'Y', '', '', '', '', '', '', '', 1),
('ATitle06_Subtitle2', '99', 'admin', 'TEL:(02)25062086  FAX:(02)25061985<br>台北市中山区长安东路二段80号8楼之4', 'ATitle06', 'Y', '', '', '', '', '', '', '', 1),
('ATitle06_RemittanceInfo', '99', 'admin', '银   行：华南商业银行(敦化分行)<br>Bankers：HUA NAN Commercial Bank, Ltd.(Dunhua Branch) Taipei, Taiwan<br>地  址：台北市大安区敦化南路二段2号<br>Address：No.2, Sec. 2, Dunhua S. Rd., Da’an Dist., Taipei City 106,Taiwan<br>帐   号：130-970-017-069      <br>Account No.：130-970-017-069   SWIFT code: HNBKTWTP<br>户  名：翰法商标事务所 <br>Beneficiary: HAN HWA Trademark Office', 'ATitle06', 'Y', '', '', '', '', '', '', '', 1)
;

delete from category where parentid='ATitle07';
INSERT INTO `category` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `ParentId`, `CategoryFlag`, `CategoryGroup`, `SubjectId_D`, `SubjectId_C`, `Helper`, `Sponsor`, `Controler`, `Memo`, `Rate`) VALUES
('ATitle07_Title', '99', 'admin', '汉华专利事务所', 'ATitle07', 'Y', '', '', '', '', '', '', '', 1),
('ATitle07_Subtitle1', '99', 'admin', 'HAN HWA PATENT OFFICE', 'ATitle07', 'Y', '', '', '', '', '', '', '', 1),
('ATitle07_Subtitle2', '99', 'admin', 'TEL:(02)25062086  FAX:(02)25061985<br>台北市中山区长安东路二段80号8楼之4', 'ATitle07', 'Y', '', '', '', '', '', '', '', 1),
('ATitle07_RemittanceInfo', '99', 'admin', '银   行：新光商业银行<br>Bankers：TAIWAN SHIN KONG Commercial Bank, Taipei, Taiwan (Formerly MACOTO Bank). <br>地  址：台北市大安区新生南路一段99号5楼<br>Address：5F, No. 99, Sec. 1, Xinsheng S. Rd., Da’an Dist., Taipei, Taiwan<br>帐   号：0611-11-077589-6  <br>Account No.：0611-11-077589-6   SWIFT code: MKTBTWTP<br>户  名：汉华专利事务所<br>Beneficiary: HAN HWA Patent Office', 'ATitle07', 'Y', '', '', '', '', '', '', '', 1)
;

delete from category where parentid='ATitle08';
INSERT INTO `category` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `ParentId`, `CategoryFlag`, `CategoryGroup`, `SubjectId_D`, `SubjectId_C`, `Helper`, `Sponsor`, `Controler`, `Memo`, `Rate`) VALUES
('ATitle08_Title', '99', 'admin', '翰华商标事务所', 'ATitle08', 'Y', '', '', '', '', '', '', '', 1),
('ATitle08_Subtitle1', '99', 'admin', 'HAN HWA TRADEMARK OFFICE', 'ATitle08', 'Y', '', '', '', '', '', '', '', 1),
('ATitle08_Subtitle2', '99', 'admin', 'TEL:(02)25062086  FAX:(02)25061985<br>台北市中山区长安东路二段80号8楼之4', 'ATitle08', 'Y', '', '', '', '', '', '', '', 1),
('ATitle08_RemittanceInfo', '99', 'admin', '银   行：华南商业银行(敦化分行)<br>Bankers：HUA NAN Commercial Bank, Ltd.(Dunhua Branch) Taipei, Taiwan<br>地  址：台北市大安区敦化南路二段2号<br>Address：No.2, Sec. 2, Dunhua S. Rd., Da’an Dist., Taipei City 106,Taiwan<br>帐   号：130-970-014-817      <br>Account No.：130-970-014-817   SWIFT code: HNBKTWTP<br>户  名：翰华商标事务所 <br>Beneficiary: HAN HWA Trademark Office', 'ATitle08', 'Y', '', '', '', '', '', '', '', 1)
;

delete from category where parentid='ATitle09';
INSERT INTO `category` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `ParentId`, `CategoryFlag`, `CategoryGroup`, `SubjectId_D`, `SubjectId_C`, `Helper`, `Sponsor`, `Controler`, `Memo`, `Rate`) VALUES
('ATitle09_Title', '99', 'admin', 'S&R IPR Consulting Corporation', 'ATitle09', 'Y', '', '', '', '', '', '', '', 1),
('ATitle09_Subtitle1', '99', 'admin', 'HAN HWA TRADEMARK OFFICE', 'ATitle09', 'Y', '', '', '', '', '', '', '', 1),
('ATitle09_Subtitle2', '99', 'admin', 'TEL:886-2-25062086  FAX:886-2-25061985<br>lillian@hanhwaip.com.tw<br>8F-4, No. 80, Sec. 2, Chang An E. Rd.,Taipei City 10455, Taiwan R.O.C', 'ATitle09', 'Y', '', '', '', '', '', '', '', 1),
('ATitle09_RemittanceInfo', '99', 'admin', 'Bankers：E.SUN COMMERCIAL BANK, LTD., TAIPEI, TAIWAN. <br>Address：No.320, Sec. 1, Jhongshan Rd., Yonghe Dist., New Taipei 234-44,Taiwan (R.O.C.).<br>Account No.：0129-957-020968 <br>SWIFT code: ESUNTWTP<br>Beneficiary: HAN HWA Trademark Office', 'ATitle09', 'Y', '', '', '', '', '', '', '', 1)
;

delete from category where parentid='ATitle10';
INSERT INTO `category` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `ParentId`, `CategoryFlag`, `CategoryGroup`, `SubjectId_D`, `SubjectId_C`, `Helper`, `Sponsor`, `Controler`, `Memo`, `Rate`) VALUES
('ATitle10_Title', '99', 'admin', 'S&R IPR Consulting Corporation', 'ATitle10', 'Y', '', '', '', '', '', '', '', 1),
('ATitle10_Subtitle1', '99', 'admin', 'HAN HWA PATENT OFFICE', 'ATitle10', 'Y', '', '', '', '', '', '', '', 1),
('ATitle10_Subtitle2', '99', 'admin', 'TEL:886-2-25062086  FAX:886-2-25061985<br>lillian@hanhwaip.com.tw<br>8F-4, No. 80, Sec. 2, Chang An E. Rd.,Taipei City 10455, Taiwan R.O.C', 'ATitle10', 'Y', '', '', '', '', '', '', '', 1),
('ATitle10_RemittanceInfo', '99', 'admin', 'Bankers：TAIWAN SHIN KONG Commercial Bank, Taipei, Taiwan (Formerly MACOTO Bank). <br>Address：5F, No. 99, Sec. 1, Hsin Sheng South Rd., Taipei, Taiwan<br>Account No.：0611-11-077589-6  <br>SWIFT code: MKTBTWTP<br>Beneficiary: HAN HWA Patent Offic', 'ATitle10', 'Y', '', '', '', '', '', '', '', 1)
;

delete from category where parentid='ATitle11';
INSERT INTO `category` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `ParentId`, `CategoryFlag`, `CategoryGroup`, `SubjectId_D`, `SubjectId_C`, `Helper`, `Sponsor`, `Controler`, `Memo`, `Rate`) VALUES
('ATitle11_Title', '99', 'admin', 'S&R IPR Consulting Corporation', 'ATitle11', 'Y', '', '', '', '', '', '', '', 1),
('ATitle11_Subtitle1', '99', 'admin', 'HAN HWA TRADEMARK OFFICE', 'ATitle11', 'Y', '', '', '', '', '', '', '', 1),
('ATitle11_Subtitle2', '99', 'admin', 'TEL:886-2-25062086  FAX:886-2-25061985<br>lillian@hanhwaip.com.tw<br>8F-4, No. 80, Sec. 2, Chang An E. Rd.,Taipei City 10455, Taiwan R.O.C', 'ATitle11', 'Y', '', '', '', '', '', '', '', 1),
('ATitle11_RemittanceInfo', '99', 'admin', 'Bankers：HUA NAN COMMERCIAL BANK, LTD. TUN HUA BRANCH. <br>Address：No.2, Sec. 2, Dunhua S. Rd., Da’an Dist., Taipei City 106,Taiwan<br>Account No.：130-970-014-817 <br>SWIFT code: HNBKTWTP<br>Beneficiary: HAN HWA Trademark Office', 'ATitle11', 'Y', '', '', '', '', '', '', '', 1)
;


delete from reportdefine where FlowKey in ('MultiExportCase_All', 'MultiDomesticCase_All', 'SingleExportCase_All', 'SingleDomesticCase_All', 'SingleImportCase_ZhCN', 'SingleImportCase_EnUs');

INSERT INTO `reportdefine` (`FlowKey`, `CreateDept`, `Applicant`, `Names`, `SampleDocument`, `ReportProgramId`) VALUES
('MultiExportCase_All', '99', 'admin', '出口案請款明細單_專商_多件', 'Document/ReportDefine/admin/UL20277.004.html', 'jsp.Invoice'),
('MultiDomesticCase_All', '99', 'admin', '國內案請款明細單_專商_多件', 'Document/ReportDefine/admin/UL20277.006.html', 'jsp.Invoice'),
('SingleExportCase_All', '99', 'admin', '出口案請款明細單_專商_單件', 'Document/ReportDefine/admin/UL20277.003.html', 'jsp.Invoice'),
('SingleDomesticCase_All', '99', 'admin', '國內案請款明細單_專商_單件', 'Document/ReportDefine/admin/UL20277.005.html', 'jsp.Invoice'),
('SingleImportCase_ZhCN', '99', 'admin', '進口案INVOICE_專商_單件(簡中)', 'Document/ReportDefine/admin/UL20277.001.html', 'jsp.Invoice'),
('SingleImportCase_EnUs', '99', 'admin', '進口案INVOICE_專商_單件(英文)', 'Document/ReportDefine/admin/UL20277.002.html', 'jsp.Invoice');

