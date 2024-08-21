
var HashMap = function () {
    let map = {};

    return {
        put: function (k, v) {
            map[k] = v;
        },
        keys: function () {
            const keySet =[];
            for (let k in map){
                keySet.push(k);
            }
            return keySet;
        },
        contains: function (k) {
           for (let a in map){
            if (a === k){
                return true;
            }
           }
           return false;
        },
        get: function (k) {
            return map[k];
        },
        clear: function () {
            map = {};
        }
    };
};