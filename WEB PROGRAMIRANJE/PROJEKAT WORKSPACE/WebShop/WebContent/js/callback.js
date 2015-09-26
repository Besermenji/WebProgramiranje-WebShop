

    window.onload = function(){

        // CHANGE THIS WITH YOUR FUNCTION

        parent.parent.postIt(getParameter(document.location.href, "code"));

    }

    function getParameter(queryString, parameterName) {

        var parameterName = parameterName + "=";

        if(queryString.length > 0) {

            begin = queryString.indexOf(parameterName);

            if(begin != -1) {

                begin += parameterName.length;

                end = queryString.indexOf("&", begin);

                if(end == -1) {

                    end = queryString.length;

                }

                return unescape(queryString.substring(begin, end));

            }

            return "";

        }

    }

