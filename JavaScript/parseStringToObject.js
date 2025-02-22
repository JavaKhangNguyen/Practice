function parseStringToObject(input){
    let obj = {};
    let stack = [];
    let key = "", value = "", isParsingKey = true;
    let i = 0;

    while (i < input.length){
        let char = input[i];

        // First char is '{' - save it first and proceed. Object starter detected
        if (char === "{") {
            stack.push(i);
            i++;
            continue;
        }

        // End of object. Check for nested object if have, reset the key for the next object handling
        if(char === '}'){
            let start = stack.pop();
            let nestedStr = input.slice(start + 1, i)
            let nestedObj = parseStringToObject(nestedStr);
            obj[key.trim()] = nestedObj
            key = ""
            isParsingKey = true;
            i++;
            continue;
        }

        // Detect key-value pair
        if(char === ':' && isParsingKey){
            isParsingKey = false;
            i++;
            continue;
        }

        // Detect next object string
        if (char === "," && stack.length === 0){
            if(key && value){
                obj[key.trim()] = `${value.trim()}`;
            }
            key = "";
            value = "";
            isParsingKey = true;
            i++;
            continue;
        }

        if (isParsingKey) {
            key += char;
        } 
        else {
            value += char;
        }
        i++;
    }

    // Matching key and value
    if (key && value) {
        obj[key.trim()] = `${value.trim()}`;
    }

    return obj
}

const testcase1 = "key1:value1, key2:{subkey1:subvalue1, subkey2:subvalue2}, key3:value3";
const testcase2 = "key1:value1, key2:{subkey1:{subsubkey1:subsubvalue1}, subkey2:subvalue2}, key3:value3"
console.log(parseStringToObject(testcase1));
console.log(parseStringToObject(testcase2))