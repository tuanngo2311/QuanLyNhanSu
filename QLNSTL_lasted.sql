USE [master]
GO

/****** Object:  Database [QLNS]    Script Date: 4/23/2021 6:28:18 PM ******/
CREATE DATABASE [QLNS]
GO
USE [QLNS]
GO
/****** Object:  Table [dbo].[TblBangCongThuViec]    Script Date: 4/23/2021 6:28:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblBangCongThuViec](
	[TenBoPhan] [nvarchar](10) NULL,
	[TenPhong] [nvarchar](50) NULL,
	[MaNV] [char](10) NOT NULL,
	[LuongTViec] [nvarchar](50) NULL,
	[Thang] [char](10) NULL,
	[Nam] [char](10) NULL,
	[SoNgayCong] [int] NULL,
	[SoNgayNghi] [int] NULL,
	[SoGioLamThem] [int] NULL,
	[GhiChu] [nvarchar](50) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblBangLuongCTy]    Script Date: 4/23/2021 6:28:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblBangLuongCTy](
	[MaLuong] [char](10) NOT NULL,
	[ChucVu] [nvarchar](50) NULL,
	[ChucDanh] [nvarchar](50) NULL,
	[LCB] [nvarchar](50) NULL,
	[PCChucVu] [int] NULL,
	[NgayNhap] [datetime] NULL,
	[LCBMoi] [int] NULL,
	[NgaySua] [datetime] NULL,
	[LyDo] [nvarchar](50) NULL,
	[PCCVuMoi] [int] NULL,
	[NgaySuaPC] [datetime] NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_TblBangLuongCTy] PRIMARY KEY CLUSTERED 
(
	[MaLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblBoPhan]    Script Date: 4/23/2021 6:28:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblBoPhan](
	[MaBophan] [char](10) NOT NULL,
	[TenBoPhan] [nvarchar](50) NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_TblBoPhan] PRIMARY KEY CLUSTERED 
(
	[MaBophan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblCongKhoiDieuHanh]    Script Date: 4/23/2021 6:28:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblCongKhoiDieuHanh](
	[MaNV] [char](10) NOT NULL,
	[LCB] [nvarchar](50) NULL,
	[PhuCapCVu] [char](4) NULL,
	[PHuCapKhac] [int] NULL,
	[Thang] [char](10) NULL,
	[Nam] [char](10) NULL,
	[LuongNgay] [char](19) NULL,
	[SoNgayCongThang] [int] NULL,
	[SoNgayNghi] [int] NULL,
	[SoGioLamThem] [int] NULL,
	[GhiChu] [nvarchar](50) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblCongKhoiSanXuat]    Script Date: 4/23/2021 6:28:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblCongKhoiSanXuat](
	[MaNV] [char](10) NOT NULL,
	[LCB] [nvarchar](50) NULL,
	[PHuCapCVu] [char](4) NULL,
	[Thang] [char](10) NULL,
	[Nam] [char](10) NULL,
	[LuongNgay] [char](19) NULL,
	[SoNgayCongThang] [int] NULL,
	[SoNgayNghi] [int] NULL,
	[SoGioLamThem] [int] NULL,
	[GhiChu] [nvarchar](50) NULL,
	[MaPhong] [char](10) NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblCongKhoiVanChuyen]    Script Date: 4/23/2021 6:28:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblCongKhoiVanChuyen](
	[MaNV] [char](10) NULL,
	[LCB] [nvarchar](50) NULL,
	[PhuCapCVu] [int] NULL,
	[PhuCapKhac] [int] NULL,
	[Thang] [char](10) NULL,
	[Nam] [char](10) NULL,
	[LuongNgay] [char](19) NULL,
	[SoNgayCongThang] [int] NULL,
	[SoNgayNghi] [int] NULL,
	[SOGioLamThem] [int] NULL,
	[GhiChu] [nvarchar](50) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblCongKhoiVanPHong]    Script Date: 4/23/2021 6:28:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblCongKhoiVanPHong](
	[MaNV] [char](10) NOT NULL,
	[LCB] [nvarchar](50) NULL,
	[PhuCapCVu] [char](4) NULL,
	[PhuCapKhac] [int] NULL,
	[Thang] [char](10) NULL,
	[Nam] [char](10) NULL,
	[LuongNgay] [char](19) NULL,
	[SoNgayCongThang] [int] NULL,
	[SoNgayNghi] [int] NULL,
	[SoGioLamThem] [int] NULL,
	[GhiChu] [nvarchar](50) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblHoSoThuViec]    Script Date: 4/23/2021 6:28:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblHoSoThuViec](
	[MaPhong] [char](10) NOT NULL,
	[MaNV] [char](10) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[NgaySinh] [datetime] NULL,
	[GioiTinh] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[TDHocVan] [nvarchar](50) NULL,
	[HocHam] [nvarchar](50) NULL,
	[ViTriThuViec] [nvarchar](50) NULL,
	[NgayTV] [datetime] NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_TblHeSoThuViec] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblPhongBan]    Script Date: 4/23/2021 6:28:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblPhongBan](
	[MaBoPhan] [char](10) NOT NULL,
	[MaPhong] [char](10) NOT NULL,
	[TenPhong] [nvarchar](50) NULL,
	[NgayTLap] [datetime] NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_TblPhongBan] PRIMARY KEY CLUSTERED 
(
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblSoBH]    Script Date: 4/23/2021 6:28:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblSoBH](
	[MaNV] [char](10) NOT NULL,
	[MaLuong] [char](10) NOT NULL,
	[MaSoBH] [char](10) NOT NULL,
	[NgayCapSo] [datetime] NULL,
	[NoiCapSo] [nvarchar](50) NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_TblSoBH] PRIMARY KEY CLUSTERED 
(
	[MaSoBH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblTangLuong]    Script Date: 4/23/2021 6:28:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblTangLuong](
	[MaNV] [char](10) NULL,
	[HoTen] [nvarchar](30) NULL,
	[GioiTinh] [nvarchar](3) NULL,
	[ChucVu] [nvarchar](50) NULL,
	[ChucDanh] [nvarchar](50) NULL,
	[LCBCu] [int] NULL,
	[LCBMoi] [int] NULL,
	[PCapCu] [int] NULL,
	[PcapMoi] [int] NULL,
	[NgayTang] [datetime] NULL,
	[LyDo] [nvarchar](50) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblTTCaNhan]    Script Date: 4/23/2021 6:28:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblTTCaNhan](
	[MaNV] [char](10) NULL,
	[NoiSinh] [nvarchar](50) NULL,
	[NguyenQuan] [nvarchar](50) NULL,
	[DCThuongChu] [nvarchar](100) NULL,
	[DCTamChu] [nvarchar](100) NULL,
	[SDT] [char](12) NULL,
	[DanToc] [nvarchar](30) NULL,
	[TonGiao] [nvarchar](20) NULL,
	[QuocTich] [nvarchar](20) NULL,
	[TiengNN] [nvarchar](50) NULL,
	[TrinhDoNN] [nvarchar](50) NULL,
	[HocVan] [nvarchar](30) NULL,
	[HocHam] [nvarchar](30) NULL,
	[NgayVaoDoan] [datetime] NULL,
	[TenDoanThe] [nvarchar](50) NULL,
	[ChucVuDoan] [nvarchar](50) NULL,
	[GhiChu] [nvarchar](50) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblTTNVCoBan]    Script Date: 4/23/2021 6:28:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblTTNVCoBan](
	[MaBoPhan] [char](10) NOT NULL,
	[MaPhong] [char](10) NOT NULL,
	[MaNV] [char](10) NOT NULL,
	[HoTen] [nvarchar](30) NULL,
	[NgaySinh] [datetime] NULL,
	[GioiTinh] [nvarchar](3) NULL,
	[CMTND] [char](12) NULL,
	[NgayCap] [datetime] NULL,
	[NoiCap] [nvarchar](50) NULL,
	[ChucVu] [nvarchar](50) NULL,
	[ChucDanh] [nvarchar](50) NULL,
	[LoaiHD] [nvarchar](50) NULL,
	[NgayKy] [datetime] NULL,
	[NgayHetHan] [datetime] NULL,
	[GhiChu] [nvarchar](100) NULL,
 CONSTRAINT [PK_TblTTNVCoBan] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblThaiSan]    Script Date: 4/23/2021 6:28:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblThaiSan](
	[MaBoPhan] [char](10) NOT NULL,
	[MaPhong] [char](10) NOT NULL,
	[MaNV] [char](10) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[NgaySinh] [datetime] NULL,
	[NgayVeSom] [datetime] NULL,
	[NgayNghiSinh] [datetime] NULL,
	[NgayLamTroLai] [datetime] NULL,
	[TroCapCTY] [int] NULL,
	[GhiChu] [nvarchar](50) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbuser]    Script Date: 4/23/2021 6:28:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbuser](
	[Username] [nvarchar](50) NOT NULL,
	[Pass] [nvarchar](50) NULL,
	[ChucVu] [nvarchar](50) NULL,
 CONSTRAINT [PK_tbuser] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[TblBangLuongCTy] ([MaLuong], [ChucVu], [ChucDanh], [LCB], [PCChucVu], [NgayNhap], [LCBMoi], [NgaySua], [LyDo], [PCCVuMoi], [NgaySuaPC], [GhiChu]) VALUES (N'ml01      ', N'Nhan vien', N'Bao ve', 1500000, 200, CAST(N'2009-05-06 00:00:00.000' AS DateTime), 2000000, CAST(N'2009-07-08 00:00:00.000' AS DateTime), N'Hoan thanh NV', 250, CAST(N'2009-07-09 00:00:00.000' AS DateTime), N'Ghi chu')
INSERT [dbo].[TblBangLuongCTy] ([MaLuong], [ChucVu], [ChucDanh], [LCB], [PCChucVu], [NgayNhap], [LCBMoi], [NgaySua], [LyDo], [PCCVuMoi], [NgaySuaPC], [GhiChu]) VALUES (N'ml01      ', N'Quan ly', N'Quan ly A', 1500000, 200, CAST(N'2009-05-06 00:00:00.000' AS DateTime), 2000000, CAST(N'2009-07-08 00:00:00.000' AS DateTime), N'', 250, CAST(N'2009-07-09 00:00:00.000' AS DateTime), N'Ghi chu')

INSERT [dbo].[TblBoPhan] ([MaBophan], [TenBoPhan], [GhiChu]) VALUES (N'bp01', N'Kinh doanh', N'Ghi chú')
INSERT [dbo].[TblBoPhan] ([MaBophan], [TenBoPhan], [GhiChu]) VALUES (N'bp02', N'Chăm sóc KH', N'Ghi chú')
INSERT [dbo].[TblBoPhan] ([MaBophan], [TenBoPhan], [GhiChu]) VALUES (N'bp03', N'Kỹ thuật', N'Ghi chú')


INSERT [dbo].[TblCongKhoiDieuHanh] ([MaNV], [LCB], [PhuCapCVu], [PHuCapKhac], [Thang], [Nam], [SoNgayCongThang], [SoNgayNghi], [SoGioLamThem], [GhiChu]) VALUES (N'001       ', 1500000, N'200 ', 150, N'12        ', N'2008               ', 4, 2, 5, N'ghddfd')

INSERT [dbo].[TblCongKhoiSanXuat] ([MaNV], [LCB], [PHuCapCVu], [Thang], [Nam], [SoNgayCongThang], [SoNgayNghi], [SoGioLamThem], [GhiChu], [MaPhong]) VALUES (N'001       ', 1500000, N'200 ', N'12        ', N'2008               ', 4, 2, 5, N'gfgtyrt', N'mp01      ')

INSERT [dbo].[TblCongKhoiVanChuyen] ([MaNV], [LCB], [PhuCapCVu], [PhuCapKhac], [Thang], [Nam], [SoNgayCongThang], [SoNgayNghi], [SOGioLamThem], [GhiChu]) VALUES (N'001       ', 1, 1, 1, N' 05       ', N' 2019              ', 1, 1, 1, N'')

INSERT [dbo].[TblCongKhoiVanPHong] ([MaNV], [LCB], [PhuCapCVu], [PhuCapKhac], [Thang], [Nam], [SoNgayCongThang], [SoNgayNghi], [SoGioLamThem], [GhiChu]) VALUES (N'001       ', 1500000, N'200 ', 150, N'12        ', N'2008               ', 4, 2, 5, N'hfdrs')

INSERT [dbo].[TblPhongBan] ([MaBoPhan], [MaPhong], [TenPhong], [NgayTLap], [GhiChu]) VALUES (N'bp01      ', N'pb01      ', N'Marketing', CAST(N'1990-03-02 00:00:00.000' AS DateTime), N'Hoạt động marketing')
INSERT [dbo].[TblPhongBan] ([MaBoPhan], [MaPhong], [TenPhong], [NgayTLap], [GhiChu]) VALUES (N'bp01      ', N'pb02      ', N'IT', CAST(N'2019-06-08 00:00:00.000' AS DateTime), N'CNTT')

INSERT [dbo].[TblSoBH] ([MaNV], [MaLuong], [MaSoBH], [NgayCapSo], [NoiCapSo], [GhiChu]) VALUES (N'001       ', N'ml01      ', N'ms01      ', CAST(N'2019-04-06 00:00:00.000' AS DateTime), N'Ho Ci Minh', N'text')

INSERT [dbo].[TblTangLuong] ([MaNV], [HoTen], [GioiTinh], [ChucVu], [ChucDanh], [LCBCu], [LCBMoi], [PCapCu], [PcapMoi], [NgayTang], [LyDo]) VALUES (N'001       ', N'Nguyen Tuan Phong', N'nam', N'truong phong', N'can bo dieu hanh', 2000000, 250000, 200, 250, CAST(N'2021-05-24 00:00:00.000' AS DateTime), N'Hoan thanh du an')

INSERT [dbo].[TblTTCaNhan] ([MaNV], [NoiSinh], [NguyenQuan], [DCThuongChu], [DCTamChu], [SDT], [DanToc], [TonGiao], [QuocTich], [TiengNN], [TrinhDoNN], [HocVan], [HocHam], [NgayVaoDoan], [TenDoanThe], [ChucVuDoan], [GhiChu]) VALUES (N'001', N'Đà Nẵng', N'Đà Nẵng', N'Đà Nẵng', N'Đà Nẵng', N'0914080804  ', N'Kinh', N'Không', N'Việt Nam', N'Việt', N'Tiếng Anh', N'Giáo sư', N'Giáo sư', CAST(N'2019-06-01 00:00:00.000' AS DateTime), N'Thiếu niên', N'text', N'text')

INSERT [dbo].[TblTTNVCoBan] ([MaBoPhan], [MaPhong], [MaNV], [HoTen], [NgaySinh], [GioiTinh], [CMTND], [NgayCap], [NoiCap], [ChucVu], [ChucDanh], [LoaiHD], [NgayKy], [NgayHetHan], [GhiChu]) VALUES (N'bp01      ', N'pb01      ', N'001       ', N'Nguyen Tuan Phong', CAST(N'1999-01-04 00:00:00.000' AS DateTime), N'nam', N'145387886   ', CAST(N'2016-05-09 00:00:00.000' AS DateTime), N'Ho Chi Minh', N'Truong phong', N'can bo dieu hanh', N'kinh te', CAST(N'2008-02-04 00:00:00.000' AS DateTime), CAST(N'2010-02-04 00:00:00.000' AS DateTime), N'can bo')
INSERT [dbo].[TblTTNVCoBan] ([MaBoPhan], [MaPhong], [MaNV], [HoTen], [NgaySinh], [GioiTinh], [CMTND], [NgayCap], [NoiCap], [ChucVu], [ChucDanh], [LoaiHD], [NgayKy], [NgayHetHan], [GhiChu]) VALUES (N'bp01      ', N'pb01      ', N'002       ', N'Dang Minh Dat', CAST(N'2000-06-02 00:00:00.000' AS DateTime), N'Nam', N'20174533', CAST(N'2016-06-02 00:00:00.000' AS DateTime), N'Đà Nẵng', N'IT', N'Nhân viên', N'CNTT', CAST(N'2019-06-02 00:00:00.000' AS DateTime), CAST(N'2019-06-02 00:00:00.000' AS DateTime), N'text')
INSERT [dbo].[TblTTNVCoBan] ([MaBoPhan], [MaPhong], [MaNV], [HoTen], [NgaySinh], [GioiTinh], [CMTND], [NgayCap], [NoiCap], [ChucVu], [ChucDanh], [LoaiHD], [NgayKy], [NgayHetHan], [GhiChu]) VALUES (N'bp01      ', N'pb01      ', N'003       ', N'Ngo Hoang Anh Tuan', CAST(N'2000-06-05 00:00:00.000' AS DateTime), N'Nữ', N'13454352', CAST(N'2016-06-05 00:00:00.000' AS DateTime), N'Dong Nai', N'text', N'text', N'text', CAST(N'2019-06-05 00:00:00.000' AS DateTime), CAST(N'2019-06-05 00:00:00.000' AS DateTime), N'text')

INSERT [dbo].[TblThaiSan] ([MaBoPhan], [MaPhong], [MaNV], [HoTen], [NgaySinh], [NgayVeSom], [NgayNghiSinh], [NgayLamTroLai], [TroCapCTY], [GhiChu]) VALUES (N'bp01      ', N'pb01      ', N'001       ', N'Nguyen Thi Mai', CAST(N'1999-01-24 00:00:00.000' AS DateTime), CAST(N'2021-04-09 00:00:00.000' AS DateTime), CAST(N'2021-06-23 00:00:00.000' AS DateTime), CAST(N'2021-10-23 00:00:00.000' AS DateTime), 500000, N'Ghhi chú')
INSERT [dbo].[TblThaiSan] ([MaBoPhan], [MaPhong], [MaNV], [HoTen], [NgaySinh], [NgayVeSom], [NgayNghiSinh], [NgayLamTroLai], [TroCapCTY], [GhiChu]) VALUES (N'bp01      ', N'pb01      ', N'002       ', N'Phi Nhung', CAST(N'1999-06-03 00:00:00.000' AS DateTime), CAST(N'2021-06-03 00:00:00.000' AS DateTime), CAST(N'2021-06-03 00:00:00.000' AS DateTime), CAST(N'2021-06-03 00:00:00.000' AS DateTime), 1, N'Ghi chú')

INSERT [dbo].[tbuser] ([Username], [Pass], [ChucVu]) VALUES (N'Direct', N'1', N'Direction')
INSERT [dbo].[tbuser] ([Username], [Pass], [ChucVu]) VALUES (N'Manager', N'1', N'Managers')
INSERT [dbo].[tbuser] ([Username], [Pass], [ChucVu]) VALUES (N'User', N'1', N'Employees')

ALTER TABLE [dbo].[TblBangCongThuViec]  WITH CHECK ADD  CONSTRAINT [FK_TblBangCongThuViec_TblHoSoThuViec] FOREIGN KEY([MaNV])
REFERENCES [dbo].[TblHoSoThuViec] ([MaNV])
GO
ALTER TABLE [dbo].[TblBangCongThuViec] CHECK CONSTRAINT [FK_TblBangCongThuViec_TblHoSoThuViec]
GO
ALTER TABLE [dbo].[TblCongKhoiDieuHanh]  WITH NOCHECK ADD  CONSTRAINT [FK_TblCongKhoiDieuHanh_TblTTNVCoBan] FOREIGN KEY([MaNV])
REFERENCES [dbo].[TblTTNVCoBan] ([MaNV])
GO
ALTER TABLE [dbo].[TblCongKhoiDieuHanh] CHECK CONSTRAINT [FK_TblCongKhoiDieuHanh_TblTTNVCoBan]
GO
ALTER TABLE [dbo].[TblCongKhoiSanXuat]  WITH CHECK ADD  CONSTRAINT [FK_TblCongKhoiSanXuat_TblPhongBan] FOREIGN KEY([MaPhong])
REFERENCES [dbo].[TblPhongBan] ([MaPhong])
GO
ALTER TABLE [dbo].[TblCongKhoiSanXuat] CHECK CONSTRAINT [FK_TblCongKhoiSanXuat_TblPhongBan]
GO
ALTER TABLE [dbo].[TblCongKhoiVanChuyen]  WITH NOCHECK ADD  CONSTRAINT [FK_TblCongKhoiVanChuyen_TblTTNVCoBan] FOREIGN KEY([MaNV])
REFERENCES [dbo].[TblTTNVCoBan] ([MaNV])
GO
ALTER TABLE [dbo].[TblCongKhoiVanChuyen] CHECK CONSTRAINT [FK_TblCongKhoiVanChuyen_TblTTNVCoBan]
GO
ALTER TABLE [dbo].[TblCongKhoiVanPHong]  WITH NOCHECK ADD  CONSTRAINT [FK_TblCongKhoiVanPHong_TblTTNVCoBan] FOREIGN KEY([MaNV])
REFERENCES [dbo].[TblTTNVCoBan] ([MaNV])
GO
ALTER TABLE [dbo].[TblCongKhoiVanPHong] CHECK CONSTRAINT [FK_TblCongKhoiVanPHong_TblTTNVCoBan]
GO
ALTER TABLE [dbo].[TblPhongBan]  WITH CHECK ADD  CONSTRAINT [FK_TblPhongBan_TblBoPhan] FOREIGN KEY([MaBoPhan])
REFERENCES [dbo].[TblBoPhan] ([MaBophan])
GO
ALTER TABLE [dbo].[TblPhongBan] CHECK CONSTRAINT [FK_TblPhongBan_TblBoPhan]
GO
ALTER TABLE [dbo].[TblSoBH]  WITH CHECK ADD  CONSTRAINT [FK_TblSoBH_TblBangLuongCTy] FOREIGN KEY([MaLuong])
REFERENCES [dbo].[TblBangLuongCTy] ([MaLuong])
GO
ALTER TABLE [dbo].[TblSoBH] CHECK CONSTRAINT [FK_TblSoBH_TblBangLuongCTy]
GO
ALTER TABLE [dbo].[TblTangLuong]  WITH NOCHECK ADD  CONSTRAINT [FK_TblTangLuong_TblTTNVCoBan] FOREIGN KEY([MaNV])
REFERENCES [dbo].[TblTTNVCoBan] ([MaNV])
GO
ALTER TABLE [dbo].[TblTangLuong] CHECK CONSTRAINT [FK_TblTangLuong_TblTTNVCoBan]
GO
ALTER TABLE [dbo].[TblThaiSan]  WITH NOCHECK ADD  CONSTRAINT [FK_TblThaiSan_TblTTNVCoBan] FOREIGN KEY([MaNV])
REFERENCES [dbo].[TblTTNVCoBan] ([MaNV])
GO
ALTER TABLE [dbo].[TblThaiSan] CHECK CONSTRAINT [FK_TblThaiSan_TblTTNVCoBan]
GO
