To do
=====
Add the following key types:
* BDK - DUKPT Master Derivation Key
* IK/IPEK - DUKPT Terminal Unique Initial Key/Initial PIN Encryption Key
EMV
---
* IMK-AC - EMV Issuer Master Key for Application Cryptogram Processing
* IMK-SMI - EMV Issuer Master Key for Script Crypto (Message Integrity)
* IMK-SMC - EMV Issuer Master for Script Crypto (Message Confidentiality)
* IMK-DAC
* IMK-IDN
Contactless [Paypass,Paywave]
-----------------------------
* IMK-CVC - Transport key for dynamic CVV processing (Contactless payment)
Card Issuance
-------------
* KTK - Transport key to encrypt data between Data Preparation and Card Personalisation System
* PTK - Transport key to encrypt PINs between Data Preparation and Card Personalisation System
* KMC - Master Personalisation Key


* NIBSS KEK Under Gemalto HSM
Clear NIBSS: DAEFCBCDB5200876ADE63B1C863DA49E
-- Component 1 - 0723CD4CDDF25A1F8F3517EEABE482C9, E2AC18
 -- Component 2 - 227A6A90957517C2E22CBC934EC55187, 1E656F
 -- Clear ZMK - 2559A7DC48874DDD6D19AB7DE521D34E, 7FF5B8
----------------
KVC of Plain Text Key   : 7FF5B8
 Encryption Key          : KM variant 10
 Length of Key Specifier : x11
 Key Specifier
 Format                  : x11
 Encrypted Key           : 8E4E F084 65D8 3628 DD80 7F5F 88B2 F181
 ------------------
 Add functions for:
 TR-31
 TR-34
 AES-DUKPT
 -----------------
@C:\Users\avandermerwe\AppData\Local\Temp\idea_junit.tmp -socket54012

Request Data: 010100010029EE08050011110969B047265CD2D555296CE552878FFA00080000000000000000086749AE56AA676EE8
Response Data: 010100010016EE08050008000000000000000008F5BFF2ED6B28BE9B00000
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0805
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0805
Error Code: 00
Output Chaining Value Length: 08
Output Chaining Value: 0000000000000000
Clear Text Length: 08
Clear Text: F5BFF2ED6B28BE9B

Request Data: 010100010029EE08040011110969B047265CD2D555296CE552878FFA00080000000000000000080000000000000000
Response Data: 010100010016EE0804000800000000000000000893376802A8962A8B00
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0804
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0804
Error Code: 00
Output Chaining Value Length: 08
Output Chaining Value: 0000000000000000
Cipher Text Length: 08
Cipher Text: 93376802A8962A8B


Request Data: 01010001002DEE02010014081011118E4EF08465D83628DD807F5F88B2F1810500111110FEDBB40FBBDE16FF2153F440593709
Response Data: 010100010018EE020100107C08445B1EE91FAEF58BA6FFCBF58DF08E80B700
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0201
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0201
Error Code: 00
Parent Key Index: 01
Parent Key Type: 10
Parent key format: 11
Parent Key Index: 01
Parent Key: 8E4EF08465D83628DD807F5F88B2F181
Key Type: 05
Encrypton Type: 00
Key Format: 11
Key: 10FEDBB40FBBDE16FF2153F440593709
Key Length: 10
DES Key Under KI: 7C08445B1EE91FAEF58BA6FFCBF58DF0
Check Digit: 8E80B7

Request Data: 01010001002DEE02010014081011118E4EF08465D83628DD807F5F88B2F181000011110969B047265CD2D555296CE552878FFA
Response Data: 010100010018EE0201001014031EE5A98BE9A35CF3BE2CFF8BABC19337680
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0201
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0201
Error Code: 00
Parent Key Index: 01
Parent Key Type: 10
Parent key format: 11
Parent Key Index: 01
Parent Key: 8E4EF08465D83628DD807F5F88B2F181
Key Type: 00
Encrypton Type: 00
Key Format: 11
Key: 0969B047265CD2D555296CE552878FFA
Key Length: 10
DES Key Under KI: 14031EE5A98BE9A35CF3BE2CFF8BABC1
Check Digit: 933768


Request Data: 01010001002DEE02010014081011118E4EF08465D83628DD807F5F88B2F18102001111F1FD7C7581E7F5AEBE1997A47F047568
Response Data: 010100010018EE020100105A226AA38414349358FA02821BCEC1BF2CA2840
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0201
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0201
Error Code: 00
Parent Key Index: 01
Parent Key Type: 10
Parent key format: 11
Parent Key Index: 01
Parent Key: 8E4EF08465D83628DD807F5F88B2F181
Key Type: 02
Encrypton Type: 00
Key Format: 11
Key: F1FD7C7581E7F5AEBE1997A47F047568
Key Length: 10
DES Key Under KI: 5A226AA38414349358FA02821BCEC1BF
Check Digit: 2CA284

Request Data: 01010001002DEE02010014081011118E4EF08465D83628DD807F5F88B2F181010011114885D70183248097F9E4B640011EDECF
Response Data: 010100010018EE02010010AB099836EAD848A3859640766BE2FFB5F9EE5C00
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0201
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0201
Error Code: 00
Parent Key Index: 01
Parent Key Type: 10
Parent key format: 11
Parent Key Index: 01
Parent Key: 8E4EF08465D83628DD807F5F88B2F181
Key Type: 01
Encrypton Type: 00
Key Format: 11
Key: 4885D70183248097F9E4B640011EDECF
Key Length: 10
DES Key Under KI: AB099836EAD848A3859640766BE2FFB5
Check Digit: F9EE5C

Request Data: 010100010007EE061900110100
Response Data: 010100010016EE06190011113E9C543B7874A8312911FD9E9AFB3E30
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0619
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0619
Error Code: 00
Key Format: 11
Key Type: 00
Response Field Length: 11
Generated Key Format: 11
DES Key Under KM: 3E9C543B7874A8312911FD9E9AFB3E30


Request Data: 010100010007EE061900110110
Response Data: 010100010016EE061900111137A217587C3519057093A0B7BD3AD8510
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0619
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0619
Error Code: 00
Key Format: 11
Key Type: 10
Response Field Length: 11
Generated Key Format: 11
DES Key Under KM: 37A217587C3519057093A0B7BD3AD851

Request Data: 010100010007EE061900110105
Response Data: 010100010016EE0619001111CC079581A339716DEC2DD27800850C570
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0619
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0619
Error Code: 00
Key Format: 11
Key Type: 05
Response Field Length: 11
Generated Key Format: 11
DES Key Under KM: CC079581A339716DEC2DD27800850C57

Request Data: 010100010007EE061900110102
Response Data: 010100010016EE0619001111868C8243277EEAD0CF7EEE4B117998510
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0619
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0619
Error Code: 00
Key Format: 11
Key Type: 02
Response Field Length: 11
Generated Key Format: 11
DES Key Under KM: 868C8243277EEAD0CF7EEE4B11799851

Request Data: 010100010007EE061900110101
Response Data: 010100010016EE0619001111794EEA21D1E26B8CB46DA7DF859286E30
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0619
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0619
Error Code: 00
Key Format: 11
Key Type: 01
Response Field Length: 11
Generated Key Format: 11
DES Key Under KM: 794EEA21D1E26B8CB46DA7DF859286E3

Request Data: 010100020007EE061900110105
Response Data: 010100020016EE06190011116711E2E6AB710B287E846A638F8E4B62
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0002
Function Code: EE0619
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0002
Response Function Code: EE0619
Error Code: 00
Key Format: 11
Key Type: 05
Response Field Length: 11
Generated Key Format: 11
DES Key Under KM: 6711E2E6AB710B287E846A638F8E4B62

Request Data: 01010001000101
Response Data: 01010001001D0100000000000000000000010000000000000000084D30393939393945000
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: 01
Function Modifier: null
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: 01
Error Code: 00
RAM Status: 00
ROM Status: 00
DES Status: 00
Host Port Status: 00
Battery Status: 00
Hard Disk Status: 00
RSA Accelerator Status: 00
Performance Level: 00
Reset Count: 0001
Calls In Last Min: 00000000
Calls in Last 10 Min: 00000000
Software ID: M099999E

Process finished with exit code 0
