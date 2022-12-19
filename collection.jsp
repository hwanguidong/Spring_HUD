<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- Header Area -->
<jsp:include page="../inc/header.jsp"/>

<!-- MegaMenu -->
<jsp:include page="../inc/megaMenu.jsp"/>

<!-- Contants Start -->
<content class="main_contents_area lg-ptb-10 lg-pr-5">
	<div class="container">
		<div class="row">
			<div class="col-lg-2 hidden-xs leftM-pdl0">
				<nav class="side-menu-area">
					<div class="display-flex-center side-menu-titlebox">
						<div class="col-xs-12">
							<h3>${menuInfo.menu_name}</h3>
						</div>
					</div>
					<div class="side-menu-list">
						<jsp:include page="../inc/menu/menu_1.jsp"/>
					</div>
				</nav>
			</div>
			<div class="col-lg-10 col-xs-12 lg-pl-70 lg-pr-0 xs-p-15 lg-pt-10">
				<content>
					<div class="lg-mb-15 xs-mb-15">
						<div class="row subheaderBox">
							<div class="col-lg-12 col-xs-12 lg-mb-m20">
								<!-- 서브타이틀 시작 -->
								<div class="text-left">
									<h1><b>${menuInfo.menu_dept1}</b></h1>
								</div>
								<!-- 서브타이틀 끝 -->
							</div>
							<div class="col-lg-6 col-xs-8 vcenter">
								<div class="row">
									<!-- 빵조각 시작 -->
									<jsp:include page="../inc/menuMap.jsp" />
									<!-- 빵조각 끝 -->
								</div>
							</div><div class="col-lg-6 col-xs-4 xs-pl-0 vbottom">
								<div class="row">
									<div class="col-lg-12 col-xs-12 text-right">
										<!-- 상단 유틸리티 버튼 시작 -->
										<jsp:include page="../inc/topUtil.jsp" />
										<!-- 상단 유틸리티 버튼 끝 -->
									</div>
								</div>
							</div>
						</div>

						<hr class="border-dark border-size-1h">

						<div class="row">
							<div class="col-lg-12 col-xs-12 vcenter">
								<div class="row">
									<div class="col-xs-12 lg-mb-10">
										<div class="lg-mt-40 text-center">
											<div class="lg-p-0">
												<ul class="nav nav-pills two-tabs">
													<li class="active lg-ptb-10">
														<a href="#1b" data-toggle="tab" class="f-large">일반검색</a>
													</li>
													<li class="lg-ptb-10">
														<a href="#2b" data-toggle="tab" class="f-large">상세검색</a>
													</li>
												</ul>
												<div class="tab-content clearfix">
													<!-- Tab Section 1 -->
													<div class="tab-pane active table-set" id="1b">
														<!-- Tab Section 1 Body -->
														<form id="search_form" action="/search/collection.do" method="post">
															<div class="book-search-box">
																<section>
																	<div class="info">
																		<i class="fas fa-exclamation-circle color-blue2"></i> <b>일반검색과 상세검색으로 필요하신 자료를 찾으실 수 있습니다.</b>
																	</div>
																	<div class="input-group search-box-form">
																		<span class="input-group-addon">
																			<div class="custom-select">
																				<select name="search_key">
																					<option value="IAL" <c:if test="${search_key == 'IAL'}">selected</c:if>>전체</option>
																					<option value="IT" <c:if test="${search_key == 'IT'}">selected</c:if>>제목</option>
																					<option value="IA" <c:if test="${search_key == 'IA'}">selected</c:if>>저자</option>
																					<option value="IP" <c:if test="${search_key == 'IP'}">selected</c:if>>발행처</option>
																					<option value="IK" <c:if test="${search_key == 'IK'}">selected</c:if>>키워드</option>
																				</select>
																			</div>
																		</span>
																		<input type="text" class="form-control" id="keyword" name="keyword" value="${keyword}" placeholder="도서명이나 출판사, 저자명을 입력하세요." autocomplete="off">
																		<div class="input-group-btn">
																		  <button class="btn btn-default" name="btn-search" type="submit">
																			<i class="glyphicon glyphicon-search"></i>
																		  </button>
																		</div>
																	</div>
																		<p>* 자료유형 [ ex) 큰글자도서, 더책(음성지원 도서), 점자도서 등]으로 입력하시면 관련 자료를 찾을 수 있습니다.</p>
																</section>
															</div>
														</form>
													</div>

													<!-- Tab Section 2 -->
													<div class="tab-pane table-set" id="2b">
														<!-- Tab Section 2 Body -->
														<form id="search_detail_form" action="/search/collectionDetail.do" method="post">
															<div class="book-search-box">
																<section>
																	<div class="info">
																		<i class="fas fa-exclamation-circle color-blue2"></i> <b>일반검색과 상세검색으로 필요하신 자료를 찾으실 수 있습니다.</b>
																	</div>
																	<div class="in-search-detail NewDataSelect">
																		<label class="radio-inline lg-mr-10 md-mr-15 rating-form" >
																			<input type="radio" class="rating-chk" id="search_type1" name="search_type" value="tot_book" checked="checked">
																			<span class="lg-ml-5">전체</span>
																		</label>
																		<label class="radio-inline lg-mr-10 md-mr-15 rating-form">
																			<input type="radio" class="rating-chk" id="search_type2" name="search_type" value="dan_book">
																			<span class="lg-ml-5">단행본</span>
																		</label>
																		<label class="radio-inline lg-mr-10 md-mr-15 rating-form">
																			<input type="radio" class="rating-chk" id="search_type3" name="search_type" value="dan_NB">
																			<span class="lg-ml-5">비도서</span>
																		</label>
																	</div>
																	<div class="row search-detail-form">
																		<div class="col-xs-12 col-lg-6">
																			<div class="input-group">
																				<span class="input-group-addon">제목</span>
																				<input type="text" class="form-control" id="IT" name="IT" value="" autocomplete="off">
																			</div>
																		</div>
																		<div class="col-xs-12 col-lg-6">
																			<div class="input-group">
																				<span class="input-group-addon">ISBN</span>
																				<input type="text" class="form-control" id="SIB" name="SIB" value="" placeholder="'-' 을  제외하고 입력하세요." autocomplete="off" data-parent="0">
																			</div>
																		</div>
																		<div class="col-xs-12 col-lg-6">
																			<div class="input-group">
																				<span class="input-group-addon">저자</span>
																				<input type="text" class="form-control" id="IA" name="IA" value="" autocomplete="off">
																			</div>
																		</div>
																		<div class="col-xs-12 col-lg-6">
																			<div class="input-group">
																				<span class="input-group-addon">발행처</span>
																				<input type="text" class="form-control" id="IP" name="IP" value="" autocomplete="off">
																			</div>
																		</div>
																		<div class="col-xs-12 col-lg-6">
																			<div class="input-group">
																				<span class="input-group-addon">발행년도</span>
																				<input type="text" class="form-control" id="YR" name="YR" value="" placeholder="숫자만 입력 (YYYY)" autocomplete="off" data-parent="0">
																			</div>
																		</div>
																		<div class="col-xs-12 col-lg-6">
																			<div class="input-group">
																				<span class="input-group-addon">정렬조건</span>
																				<div class="input-group New-select">
																					<select class="select-selected" id="ord" name="ord">
																						<option value="">전체</option>
																						<option value="IT">제목</option>
																						<option value="IA">저자</option>
																						<option value="IP">발행처</option>
																						<option value="IK">키워드</option>
																					</select>
																				</div>
																			</div>
																		</div>
																	</div>
																	<div class="row">
																		<div class="col-xs-12 col-lg-12 text-center">
																			<button type="button" name="btn-detail-search" class="subBtn">검색</button>
																		</div>
																	</div>
																</section>
															</div>
														</form>
													</div>
												</div>
											</div>
										</div>
									</div>

									<c:if test="${keyword ne null}">
										<!-- 검색결과 매세지-->
										<div class="col-xs-12 lg-mt-30 xs-mt-20">
											<div class="search-result-msg">
												요청한 검색어 <span>${key}:${keyword}</span> 에 대한 검색결과이며 총 <b>${paginationInfo.totalRecordCount}건</b>이 검색되었습니다.
											</div>
											<hr class="border-dark border-size-1h">
										</div>

										<!-- 검색결과 Block List-->
										<div class="col-xs-12">
											<div class="row book-list-block">
												<!-- 검색결과 Block 시작 -->
												<c:if test="${paginationInfo.totalRecordCount > 0}">
													<c:forEach items="${results}" var="result" varStatus="status">
														<div class="col-xs-12 col-md-6 col-lg-12">
															<div class="row">
																<div class="usul-book-list after">
																	<a href="javascript:;" name="btn-view" data-num="${result.REG_NO}" data-isbn="${result.ST_CODE}" data-code="${result.REG_CODE}">
																		<div class="col-xs-12 col-lg-2 thumnail movie_thum">
																			<c:choose>
																				<c:when test="${not empty result.img_path}">
																					<img src="${result.img_path}" alt="book_img">
																				</c:when>
																				<c:otherwise>
																					<img src="<%=request.getContextPath()%>/images/dummy/noimg.jpg" alt="book_img">
																				</c:otherwise>
																			</c:choose>
																		</div>
																	</a>
																	<div class="col-xs-12 col-lg-10 text-left">
																		<div class="row book-list-data">
																			<a href="javascript:;" name="btn-view" data-num="${result.REG_NO}" data-isbn="${result.ST_CODE}" data-code="${result.REG_CODE}">
																				<div class="col-xs-12 booktrailer_title" data-title="${result.TITLE_INFO}">
																					<span>
																						<c:choose>
																							<c:when test="${fn:indexOf(result.REG_CODE, 'NB') > -1}">비도서</c:when>
																							<c:otherwise>단행본</c:otherwise>
																						</c:choose>
																					</span> <b>${result.TITLE_INFO}</b>
																				</div>
																				<div class="col-xs-12" name="info">
																					<content>
																						<div class="row">
																							<div class="col-xs-12">
																								<div name="author" data-author="${result.AUTHOR_INFO}">저자 : ${result.AUTHOR_INFO}</div>
																								<div name="publisher" data-publisher="${result.PUB_INFO}">발행처 : ${result.PUB_INFO}</div>
																								<div name="year" data-year="${result.IDX_IPUB_YEAR}">발행년도 : ${result.IDX_IPUB_YEAR}</div>
																							</div>
																							<div class="col-xs-12">
																								<div>청구기호 : ${result.CALLNO_INFO}</div>
																								<div>등록번호 : ${result.REG_NO}</div>
																								<div>자료위치 : ${result.PLACE_INFO}</div>
																							</div>
																						</div>
																					</content>
																				</div>
																			</a>
																			<div class="col-xs-12">
																				<div class="book-status">
																					<c:set var="loan_enable_flag" value="N"/>
																					<!--
																						loan_status : 대출상태. N이면 대출가능. 아니면 관외대출중
																						loan_enable_flag : 대출가능여부. YYYY면 대출가능.
																						reservation_yn : 예약인원수. 1이라도 예약이 있을경우 대출 불가능하여야 함.
																						reservation_limit_usercount : 예약 최대인원 수
																						PLACE_INFO : 자료위치. 스마트도서관의 경우 예약불가(울주도서관만 해당)
																					 -->
																					<c:choose>
																						<c:when test="${result.loan_status eq 'N'}">
																							<c:choose>
																								<c:when test="${result.loan_enable_flag eq 'YYYY'}">
																									<c:choose>
																										<c:when test="${result.reservation_yn < 1 }">
																											<b class="color-blue">대출가능[비치중]</b>
																										</c:when>
																										<c:otherwise>
																											<b class="color-danger">대출불가</b> (예약 : ${result.reservation_yn}/${result.reservation_limit_usercount } 명)
																											<c:if test="${result.reservation_yn < result.reservation_limit_usercount }">
																												<c:set var="loan_enable_flag" value="Y"/>
																											</c:if>
																										</c:otherwise>
																									</c:choose>
																								</c:when>
																								<c:otherwise>
																									<b class="color-danger">대출불가</b>
																									<c:if test="${result.reservation_yn < result.reservation_limit_usercount }">
																										<c:set var="loan_enable_flag" value="Y"/>
																									</c:if>
																								</c:otherwise>
																							</c:choose>
																						</c:when>
																						<c:otherwise>
																							<b class="color-danger">관외 대출중</b> (예약 : ${result.reservation_yn}/${result.reservation_limit_usercount } 명) (반납예정 : ${result.loan_status})
																							<c:if test="${result.reservation_yn < result.reservation_limit_usercount }">
																								<c:set var="loan_enable_flag" value="Y"/>
																							</c:if>
																						</c:otherwise>
																					</c:choose>
																				</div>
																			</div>
																			<div class="col-xs-12">
																				<div class="book-btn">
																					<c:choose>
																						<c:when test="${loan_enable_flag eq 'Y' && result.PLACE_INFO ne '스마트도서관' }">
																							<button class="btn btn-primary" name="btn-reserv-info" style="position: relative; z-index: 1">
																								<i class="far fa-calendar-check"></i> 예약 가능
																							</button>
																						</c:when>
																						<c:otherwise>
																							<button class="btn btn-danger" name="btn-reserv-info" style="position: relative; z-index: 1">
																								<i class="far fa-window-close"></i> 예약 불가
																							</button>
																						</c:otherwise>
																					</c:choose>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<hr class="border-grey border-size-1">
														</div>
													</c:forEach>
												</c:if>
												<!-- 검색결과 Block 끝 -->
											</div>
										</div>

										<!-- 페이징 -->
										<div class="col-lg-12">
											<div class="row">
												<c:if test="${paginationInfo.totalRecordCount > 0}">
													<jsp:include page="../inc/autoPaging.jsp">
														<jsp:param name="page_val" value="collection" />
														<jsp:param name="keyword" value="${keyword}" />
														<jsp:param name="search_key" value="${search_key}" />
													</jsp:include>
												</c:if>
											</div>
										</div>
									</c:if>
								</div>
							</div>
						</div>
					</div>

					<!-- 하단 담당자 정보 및 만족도 평가 영역 시작 -->
					<jsp:include page="../inc/subpage/page_info/01.jsp"/>
					<!-- 하단 담당자 정보 및 만족도 평가 영역 끝 -->
				</content>
			</div>
		</div>
	</div>
</content>
<!-- Contants End -->

<script type="text/javascript" src="../js/app/views/search/Collection.js"></script>

<!-- Footer Area -->
<jsp:include page="../inc/footer.jsp"/>