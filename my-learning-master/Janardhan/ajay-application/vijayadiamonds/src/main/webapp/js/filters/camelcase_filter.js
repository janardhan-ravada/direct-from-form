angular.module('routerApp').filter(
    'camelCase', function(){

        return function(inputs, attrs){

            attrs.forEach(function(item){
                inputs = camelCaseConversationForAttr(inputs,item);
            });
            return inputs;
        }

        var toCamelcase = function(str){
            return (str === undefined || str === null) ? '' : str.replace(
                /_|-/, ' ').replace(
                /\w\S*/g,
                function (txt) {
                    return txt.charAt(0).toUpperCase()
                        + txt.substr(1).toLowerCase();
                });
        }

        var camelCaseConversationForAttr = function(inputs, attr){
            var result = new Array(inputs.length);
            inputs.forEach(function(item){
                item[attr]=toCamelcase(item[attr]);
                result.push(item)
            });
            return result;
        }
    });