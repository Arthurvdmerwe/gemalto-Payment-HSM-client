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
 [1, 1, 0, 2, 0, 7, -18, 6, 25, 0, 17, 1, 5]

Request Data: 010100020007EE061900110105
Response Data: 
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0002
Function Code: EE0619
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0002
Response Function Code: EE0619
Error Code: 0A
Key Format: 11
Key Type: 05
Response Field Length: null
Generated Key Format: null
DES Key Under KM: null
[1, 1, 0, 1, 0, 7, -18, 6, 25, 0, 17, 1, 0]

Request Data: 010100010007EE061900110100
Response Data: 
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0619
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0619
Error Code: 0A
Key Format: 11
Key Type: 00
Response Field Length: null
Generated Key Format: null
DES Key Under KM: null
[1, 1, 0, 1, 0, 45, -18, 2, 1, 0, 20, 8, 16, 17, 17, -114, 78, -16, -124, 101, -40, 54, 40, -35, -128, 127, 95, -120, -78, -15, -127, 5, 0, 17, 17, 16, -2, -37, -76, 15, -69, -34, 22, -1, 33, 83, -12, 64, 89, 55, 9]

Request Data: 01010001002DEE02010014081011118E4EF08465D83628DD807F5F88B2F1810500111110FEDBB40FBBDE16FF2153F440593709
Response Data: 
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0201
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0201
Error Code: 0A
Parent Key Index: 01
Parent Key Type: 10
Parent key format: 11
Parent Key Index: 01
Parent Key: 8E4EF08465D83628DD807F5F88B2F181
Key Type: 05
Encrypton Type: 00
Key Format: 11
Key: 10FEDBB40FBBDE16FF2153F440593709
Key Length: null
DES Key Under KI: null
Check Digit: null
[1, 1, 0, 1, 0, 45, -18, 2, 1, 0, 20, 8, 16, 17, 17, -114, 78, -16, -124, 101, -40, 54, 40, -35, -128, 127, 95, -120, -78, -15, -127, 0, 0, 17, 17, 9, 105, -80, 71, 38, 92, -46, -43, 85, 41, 108, -27, 82, -121, -113, -6]

Request Data: 01010001002DEE02010014081011118E4EF08465D83628DD807F5F88B2F181000011110969B047265CD2D555296CE552878FFA
Response Data: 
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0201
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0201
Error Code: 0A
Parent Key Index: 01
Parent Key Type: 10
Parent key format: 11
Parent Key Index: 01
Parent Key: 8E4EF08465D83628DD807F5F88B2F181
Key Type: 00
Encrypton Type: 00
Key Format: 11
Key: 0969B047265CD2D555296CE552878FFA
Key Length: null
DES Key Under KI: null
Check Digit: null
[1, 1, 0, 1, 0, 7, -18, 6, 25, 0, 17, 1, 2]

Request Data: 010100010007EE061900110102
Response Data: 
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0619
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0619
Error Code: 0A
Key Format: 11
Key Type: 02
Response Field Length: null
Generated Key Format: null
DES Key Under KM: null
[1, 1, 0, 1, 0, 41, -18, 8, 4, 0, 17, 17, 9, 105, -80, 71, 38, 92, -46, -43, 85, 41, 108, -27, 82, -121, -113, -6, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0]

Request Data: 010100010029EE08040011110969B047265CD2D555296CE552878FFA00080000000000000000080000000000000000
Response Data: 
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0804
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0804
Error Code: 0A
Output Chaining Value Length: null
Output Chaining Value: null
Cipher Text Length: null
Cipher Text: null
[1, 1, 0, 1, 0, 45, -18, 2, 1, 0, 20, 8, 16, 17, 17, -114, 78, -16, -124, 101, -40, 54, 40, -35, -128, 127, 95, -120, -78, -15, -127, 1, 0, 17, 17, 72, -123, -41, 1, -125, 36, -128, -105, -7, -28, -74, 64, 1, 30, -34, -49]

Request Data: 01010001002DEE02010014081011118E4EF08465D83628DD807F5F88B2F181010011114885D70183248097F9E4B640011EDECF
Response Data: 
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0201
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0201
Error Code: 0A
Parent Key Index: 01
Parent Key Type: 10
Parent key format: 11
Parent Key Index: 01
Parent Key: 8E4EF08465D83628DD807F5F88B2F181
Key Type: 01
Encrypton Type: 00
Key Format: 11
Key: 4885D70183248097F9E4B640011EDECF
Key Length: null
DES Key Under KI: null
Check Digit: null
[1, 1, 0, 1, 0, 7, -18, 6, 25, 0, 17, 1, 1]

Request Data: 010100010007EE061900110101
Response Data: 
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0619
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0619
Error Code: 0A
Key Format: 11
Key Type: 01
Response Field Length: null
Generated Key Format: null
DES Key Under KM: null
[1, 1, 0, 1, 0, 45, -18, 2, 1, 0, 20, 8, 16, 17, 17, -114, 78, -16, -124, 101, -40, 54, 40, -35, -128, 127, 95, -120, -78, -15, -127, 2, 0, 17, 17, -15, -3, 124, 117, -127, -25, -11, -82, -66, 25, -105, -92, 127, 4, 117, 104]

Request Data: 01010001002DEE02010014081011118E4EF08465D83628DD807F5F88B2F18102001111F1FD7C7581E7F5AEBE1997A47F047568
Response Data: 
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0201
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0201
Error Code: 0A
Parent Key Index: 01
Parent Key Type: 10
Parent key format: 11
Parent Key Index: 01
Parent Key: 8E4EF08465D83628DD807F5F88B2F181
Key Type: 02
Encrypton Type: 00
Key Format: 11
Key: F1FD7C7581E7F5AEBE1997A47F047568
Key Length: null
DES Key Under KI: null
Check Digit: null
[1, 1, 0, 1, 0, 7, -18, 6, 25, 0, 17, 1, 5]

Request Data: 010100010007EE061900110105
Response Data: 
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0619
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0619
Error Code: 0A
Key Format: 11
Key Type: 05
Response Field Length: null
Generated Key Format: null
DES Key Under KM: null
[1, 1, 0, 1, 0, 1, 1]

Request Data: 01010001000101
Response Data: 
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
Reset Count: 0004
Calls In Last Min: 00000000
Calls in Last 10 Min: 00000002
Software ID: M099999E
[1, 1, 0, 1, 0, 41, -18, 8, 5, 0, 17, 17, 9, 105, -80, 71, 38, 92, -46, -43, 85, 41, 108, -27, 82, -121, -113, -6, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 8, 103, 73, -82, 86, -86, 103, 110, -24]

Request Data: 010100010029EE08050011110969B047265CD2D555296CE552878FFA00080000000000000000086749AE56AA676EE8
Response Data: 
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0805
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0805
Error Code: 0A
Output Chaining Value Length: null
Output Chaining Value: null
Clear Text Length: null
Clear Text: 6749AE56AA676EE8
[1, 1, 0, 1, 0, 7, -18, 6, 25, 0, 17, 1, 16]

Request Data: 010100010007EE061900110110
Response Data: 
Request Header SOH Character: 01
Request Header Version: 01
Request Sequence: 0001
Function Code: EE0619
Function Modifier: 00
Response Header SOH Character: 01
Response Header Version: 01
Response Sequence: 0001
Response Function Code: EE0619
Error Code: 0A
Key Format: 11
Key Type: 10
Response Field Length: null
Generated Key Format: null
DES Key Under KM: null
