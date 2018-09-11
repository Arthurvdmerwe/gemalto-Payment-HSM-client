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

KVC of Plain Text Key   : 7FF5B8
 Encryption Key          : KM variant 10
 Length of Key Specifier : x11
 Key Specifier
 Format                  : x11
 Encrypted Key           : 8E4E F084 65D8 3628 DD80 7F5F 88B2 F181