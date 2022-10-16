asciiList = [c for c in (chr(i) for i in range(32,127))]


def keyForText(text, key):
    key = list(key)
    textLen = len(text)
    keyLen = len(key)
    if textLen == keyLen:
        return(key)
    else:
        for i in range(len(text) -keyLen):
            key.append(key[i % keyLen])
    return("" . join(key))

def encrypt(text, key, asciiList):
    cipherText = []
    for i in range(len(text)):
        k = asciiList.index(key[i])
        t = asciiList.index(text[i])
        temp = asciiList[(t+k) % len(asciiList)]
        cipherText.append(temp)
    return("" . join(cipherText))

def decrypt(cipherText, key,asciiList):
    text = []
    for i in range(len(cipherText)):
        k = asciiList.index(key[i])
        t = asciiList.index(cipherText[i])
        temp = asciiList[(t-k+len(asciiList)) % len(asciiList)]
        text.append(temp)
    return("" . join(text))

def vigenereEncrpytDecrypt(text, key, typ):
    error = 0
    if not text:
        print ('No text provided')
        error += 1
    if key:
        if len(key)>3:
            print("Please enter key with 1-3 characters")
            error += 1
        flag = False
        for i in key:
            if ord(i) < 65 or ord(i) > 90:
                flag = True
        if flag: 
            print("Please provide only upper case characters")
            error += 1
    else:
        print("No key provided")
        error += 1
    if typ not in ('d', 'e'):
        print ('Provide "d" for decrypt or "e" for encrypt')
        error += 1
    
    if error != 0:
        print("Number of errors found = ",error)
        print("Please retry")
        return

    # if typ == 'e':
    #     text = text.replace(" ", "")
    
    resultText = ''
    updatedKey = keyForText(text,key)

    if typ == 'e':
        resultText = encrypt(text,updatedKey,asciiList)
    else:
        resultText = decrypt(text,updatedKey,asciiList)

    print(resultText)
    return resultText

plainText = input("Please input plain text or cipher text = ")
key = input("Please input Key = ")
encryptDecrypt = input('Provide "d" for decrypt or "e" for encrypt = ')
vigenereEncrpytDecrypt(plainText,key,encryptDecrypt)

