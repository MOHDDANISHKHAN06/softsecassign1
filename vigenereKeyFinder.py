asciiList = [c for c in (chr(i) for i in range(65,91))]

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

def decrypt(cipherText, key,asciiList):
    text = []
    for i in range(len(cipherText)):
        k = asciiList.index(key[i])
        t = asciiList.index(cipherText[i])
        temp = asciiList[(t-k) % len(asciiList)]
        text.append(temp)
    return("" . join(text))

def keyFinder(pText,cText,asciiList):
    if len(pText) != len(cText):
        print("Lengths of the plain text and cipher text do not match")
        return
    keyLen = [1,2,3] # Given that the Key length can only be between 1-3
    # For Key length == 1
    key = ''
    keys = []
    for h in keyLen:
        print("Keys of length ",h," :")
        j = 0
        i = 0
        while j < len(asciiList):
            if h == 1:
                keys.append(asciiList[j])
                print(asciiList[j])
            if len(key)!=h:
                if key and h != 1:
                    if key+asciiList[j] not in keys:
                        keys.append(key+asciiList[j])
                        print(key+asciiList[j])
                c = asciiList.index(cipherText[i])
                p = asciiList.index(plainText[i])
                a = (c-j)%len(asciiList)
                if a == p:
                    key +=asciiList[j]
                    i+=1
                    j = 0
                else:
                    j+=1
            if key:
                if len(key) == h:  
                    keyUpdate = keyForText(pText,key)
                    result = decrypt(cText,keyUpdate,asciiList)
                    if result == pText:
                        print(keys)
                        with open('output.txt', 'a') as f:
                            f.write("Keys checked = ")
                            for k in keys:
                                f.write(k+", ")
                            f.write("\nTotal number of keys checked = "+str(len(keys)))
                            f.write("\nActual key found = "+key+"\n")
                        return key
                    else:
                        key = ''
                        break
                    
                   

plainText = 'ARIZONASTATEUNIVERSITY'
cipherText = 'EUCDRHEVNEWYYQCZHLWLNC'
print("Plain Text = "+plainText+"\nCipher Text = "+cipherText)
with open('output.txt', 'w') as f:
    f.writelines("Plain Text = "+plainText+"\nCipher text = "+cipherText+"\n")
key = keyFinder(plainText,cipherText,asciiList)
print("KEY = "+key)
plainText = 'COMPUTERSCIENCE'
cipherText = 'GRGTXNIUMGLYRFY'
print("Plain Text = "+plainText+"\nCipher Text = "+cipherText)
with open('output.txt', 'a') as f:
    f.writelines("Plain Text = "+plainText+"\nCipher text = "+cipherText+"\n")
key = keyFinder(plainText,cipherText,asciiList)
print("KEY = "+key)
