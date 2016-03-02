currencyExchengeApp.service(
    "currencyService",
    function ($http, $q) {
        // API
        return ({
            getCurrencyList: getCurrencyList,
            getHistoryRates: getHistoryRates,
            removeFriend: removeFriend
        });

        // PUBLIC METHODS.

        // Get currencies list
        function getCurrencyList() {
            var request = $http({
                method: "get",
                url: "exchange/currencies",
            });
            return ( request.then(handleSuccess, handleError) );
        }

        // Get history rates by currency name
        function getHistoryRates(name) {
            var request = $http({
                method: "get",
                url: "exchange/getHistory",
                params: {
                    action: "get",
                    currency : name
                }
            });
            return ( request.then(handleSuccess, handleError) );
        }

        // PRIVATE METHODS.

        // Transform the error response, unwrapping the application dta from
        // the API response payload.
        function handleError(response) {
            if (
                !angular.isObject(response.data) || !response.data.message
            ) {
                return ( $q.reject("An unknown error occurred.") );
            }
            return ( $q.reject(response.data.message) );
        }

        // I transform the successful response, unwrapping the application data
        // from the API response payload.
        function handleSuccess(response) {
            return ( response.data );
        }
    }
);