<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <title>userList</title>
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
                        <h2>USER LIST</h2>
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
                            <th> 이메일 </th>
                            <th> 닉네임 </th>
                            <th> 가입날짜 </th>
                            <th> 연락처 </th>
                            <th colspan="2"> 관리 </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td> 1 </td>
                            <td> Herman Beck </td>
                            <td> Beck </td>
                            <td> May 15, 2015 </td>
                            <td> 01012345678 </td>
                            <td><button type="button" class="btn btn-outline-warning btn-fw">정보수정</button></td>
                            <td><button type="button" class="btn btn-outline-danger btn-fw">강제탈퇴</button></td>
                        </tr>
                        <tr>
                            <td> 2 </td>
                            <td> Herman Beck </td>
                            <td> Beck </td>
                            <td> May 15, 2015 </td>
                            <td> 01012345678 </td>
                            <td><button type="button" class="btn btn-outline-warning btn-fw">정보수정</button></td>
                            <td><button type="button" class="btn btn-outline-danger btn-fw">강제탈퇴</button></td>
                        </tr>
                        <tr>
                            <td> 3 </td>
                            <td> Herman Beck </td>
                            <td> Beck </td>
                            <td> May 15, 2015 </td>
                            <td> 01012345678 </td>
                            <td><button type="button" class="btn btn-outline-warning btn-fw">정보수정</button></td>
                            <td><button type="button" class="btn btn-outline-danger btn-fw">강제탈퇴</button></td>
                        </tr>
                        <tr>
                            <td> 4 </td>
                            <td> Herman Beck </td>
                            <td> Beck </td>
                            <td> May 15, 2015 </td>
                            <td> 01012345678 </td>
                            <td><button type="button" class="btn btn-outline-warning btn-fw">정보수정</button></td>
                            <td><button type="button" class="btn btn-outline-danger btn-fw">강제탈퇴</button></td>
                        </tr>
                        <tr>
                            <td> 5 </td>
                            <td> Herman Beck </td>
                            <td> Beck </td>
                            <td> May 15, 2015 </td>
                            <td> 01012345678 </td>
                            <td><button type="button" class="btn btn-outline-warning btn-fw">정보수정</button></td>
                            <td><button type="button" class="btn btn-outline-danger btn-fw">강제탈퇴</button></td>
                        </tr>
                    </tbody>
                </table>
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