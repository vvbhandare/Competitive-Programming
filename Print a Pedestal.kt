fun main(args: Array<String>) {

    var t = readLine()?.toInt()

    for (i in 0 until t!!) {

        var n = readLine()?.toInt()

        var dby3 = n!! / 3

        var rby3 = n % 3

        if (rby3 == 0) {

            var ff = dby3 + 1  //4
            var ss = dby3  //3
            var tt = n - ff - ss //2

            println("$ss $ff $tt")

        } else {

            if (rby3 == 1) {

                var ff = dby3 + 2 // 5
                var ss = dby3 // 3

                var tt = n - ff - ss //2

                println("$ss $ff $tt")

            } else {

                var ff = dby3 + 2 //5
                var ss = dby3 + 1 //4

                var tt = n - ff - ss // 2

                println("$ss $ff $tt")

            }

        }

    }

}