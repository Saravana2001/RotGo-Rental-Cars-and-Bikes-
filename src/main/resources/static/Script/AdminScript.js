$(document).ready(function () {

            $(".hamburger .con").click(function () {
                $(".wrapper").toggleClass("active")
            })

            $(".top_navbar .fas").click(function () {
                $(".profile_dd").toggleClass("active");
            });
        })


        $(document).ready(function () {

            $(".dashboard_btn").addClass("active");
            $(".dashboard").removeClass("hidden");
            $(".vehicle_details").addClass("hidden");
            $(".owner_details").addClass("hidden");
            $(".customer_details").addClass("hidden");

            $(".dashboard_btn").click(function () {
                $(".dashboard_btn").addClass("active");
                $(".vehicles_btn").removeClass("active");
                $(".owner_btn").removeClass("active");
                $(".dashboard").removeClass("hidden");
                $(".vehicle_details").addClass("hidden");
                $(".owner_details").addClass("hidden");
                $(".customer_details").addClass("hidden");
            })
            $(".vehicles_btn").click(function () {
                $(".dashboard_btn").removeClass("active");
                $(".owner_btn").removeClass("active");
                $(".customer_btn").removeClass("active");
                $(".vehicles_btn").addClass("active");
                $(".dashboard").addClass("hidden");
                $(".customer_details").addClass("hidden");
                $(".owner_details").addClass("hidden");
                $(".vehicle_details").removeClass("hidden");

            });
            $(".owner_btn").click(function () {
                $(".dashboard_btn").removeClass("active");
                $(".customer_btn").removeClass("active");
                $(".vehicles_btn").removeClass("active");
                $(".owner_btn").addClass("active");
                $(".dashboard").addClass("hidden");
                $(".vehicle_details").addClass("hidden");
                $(".customer_details").addClass("hidden");
                $(".owner_details").removeClass("hidden");
            });
            $(".customer_btn").click(function () {
                $(".dashboard_btn").removeClass("active");
                $(".vehicles_btn").removeClass("active");
                $(".owner_btn").removeClass("active");
                $(".customer_btn").addClass("active");
                $(".dashboard").addClass("hidden");
                $(".vehicle_details").addClass("hidden");
                $(".owner_details").addClass("hidden");
                $(".customer_details").removeClass("hidden");
            });

        });