var input_var_1 = "input variable 1";
var input_var_2 = "input variable 2";
var input_var_3 = "input variable 3";

// Convert input lists to arrays if they aren't already
    var var1 = input_var_1.toString().split(/\r?\n/)
        .map(line => line.trim()).filter(line => line.length > 0).join(',');
    var var2 = input_var_2.toString().split(',');
    var var3 = input_var_3.toString().split(',');
    
    /* Main logic to process the updating operations */
    // Start with current members
    result = var1.split(',').map(m => m.trim()).filter(m => m.length > 0);
    
    // Add new members (avoid duplicates)
    for (var j = 0; j < var2.length; j++) {
        var elementToAdd = var2[j].trim();
        if (elementToAdd.length > 0 && result.indexOf(elementToAdd) === -1) {
            result.push(elementToAdd);
        }
    }
    
    // Remove members
    for (var k = 0; k < var3.length; k++) {
        var elementToRemove = var3[k].trim();
        if (elementToRemove.length > 0) {
            var index = result.indexOf(elementToRemove);
            if (index !== -1) {
                result.splice(index, 1);
            }
        }
    }
   
    return result.join(',');