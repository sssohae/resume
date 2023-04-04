<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <title>reportPage</title>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Normal Breadcrumb Begin -->
    <section class="normal-breadcrumb set-bg" data-setbg="img/normal-breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="normal__breadcrumb__text">
                        <h2>EMPTY PAGE</h2>
                        <p>empty</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Signup Section Begin -->
    <section class="signup spad">
        <div class="container">
            <div class="row">
                <table class="table table-dark">
                    <thead>
                        <tr>
                            <th> # </th>
                            <th> 신고된 아이디 </th>
                            <th> 신고한 아이디 </th>
                            <th> 신고날짜 </th>
                            <th> 사유 </th>
                            <th> 체크 </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td> 1 </td>
                            <td> Herman Beck </td>
                            <td> Herman Beck </td>
                            <td> May 15, 2015 </td>
                            <td> 분란조장 </td>
                            <td><input type="checkbox" name="chk"></td>
                        </tr>
                        <tr>
                            <td> 2 </td>
                            <td> Messsy Adam </td>
                            <td> Messsy Adam </td>
                            <td> July 1, 2015 </td>
                            <td> 분란조장 </td>
                            <td><input type="checkbox" name="chk"></td>
                        </tr>
                        <tr>
                            <td> 3 </td>
                            <td> John Richards </td>
                            <td> Messsy Adam </td>
                            <td> Apr 12, 2015 </td>
                            <td> 분란조장 </td>
                            <td><input type="checkbox" name="chk"></td>
                        </tr>
                        <tr>
                            <td> 4 </td>
                            <td> Peter Meggik </td>
                            <td> Messsy Adam </td>
                            <td> May 15, 2015 </td>
                            <td> 분란조장 </td>
                            <td><input type="checkbox" name="chk"></td>
                        </tr>
                        <tr>
                            <td> 5 </td>
                            <td> Edward </td>
                            <td> Messsy Adam </td>
                            <td> May 03, 2015 </td>
                            <td> 분란조장 </td>
                            <td><input type="checkbox" name="chk"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="row">
                <div class="template-demo">
                    <button type="button" class="btn btn-success btn-fw">신고해제</button>
                    <button type="button" class="btn btn-warning btn-fw">댓글삭제</button>
                    <button type="button" class="btn btn-danger btn-fw">차단</button>
                </div>
            </div>
        </div>
    </section>
    <!-- Signup Section End -->

    <!-- Search model Begin -->
    <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch"><i class="icon_close"></i></div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>
    <!-- Search model end -->

</body>

</html>