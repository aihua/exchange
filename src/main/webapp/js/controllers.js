currencyExchengeApp.controller('ExchangeController', function($scope, currencyService) {
    //$scope.square = function() {
    //    $scope.result = CalcService.square($scope.number);
    //}
    $scope.init = function() {
        $scope.currencies = $scope.getList();
    };

    $scope.getList = function() {
        currencyService.getCurrencyList()
            .then(
                function( currencies ) {
                    loadData( currencies );
                }
            )
    };

    $scope.valueChanged = function() {
        currencyService.getHistoryRates($scope.selected)
            .then(
                loadData(),
                function( errorMessage ) {
                    alert( errorMessage );
                }
            )
    };

    function loadData( newCurrencies ) {
        $scope.currencies = newCurrencies;
    };

    function loadHistory( historyList ) {
        $scope.historyList = historyList;
    };
});