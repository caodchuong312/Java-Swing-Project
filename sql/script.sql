USE [master]
GO
/****** Object:  Database [quanlychitieu]    Script Date: 1/5/2024 3:29:57 PM ******/
CREATE DATABASE [quanlychitieu]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'quanlychitieu', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\quanlychitieu.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'quanlychitieu_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\quanlychitieu_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [quanlychitieu] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [quanlychitieu].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [quanlychitieu] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [quanlychitieu] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [quanlychitieu] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [quanlychitieu] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [quanlychitieu] SET ARITHABORT OFF 
GO
ALTER DATABASE [quanlychitieu] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [quanlychitieu] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [quanlychitieu] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [quanlychitieu] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [quanlychitieu] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [quanlychitieu] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [quanlychitieu] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [quanlychitieu] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [quanlychitieu] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [quanlychitieu] SET  ENABLE_BROKER 
GO
ALTER DATABASE [quanlychitieu] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [quanlychitieu] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [quanlychitieu] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [quanlychitieu] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [quanlychitieu] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [quanlychitieu] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [quanlychitieu] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [quanlychitieu] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [quanlychitieu] SET  MULTI_USER 
GO
ALTER DATABASE [quanlychitieu] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [quanlychitieu] SET DB_CHAINING OFF 
GO
ALTER DATABASE [quanlychitieu] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [quanlychitieu] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [quanlychitieu] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [quanlychitieu] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [quanlychitieu] SET QUERY_STORE = OFF
GO
USE [quanlychitieu]
GO
/****** Object:  Table [dbo].[tblChiTieu]    Script Date: 1/5/2024 3:29:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblChiTieu](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ngay] [date] NULL,
	[danhMucID] [int] NULL,
	[tien] [decimal](18, 2) NULL,
	[userID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblDanhMuc]    Script Date: 1/5/2024 3:29:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblDanhMuc](
	[id] [int] NOT NULL,
	[danhMuc] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblNganSach]    Script Date: 1/5/2024 3:29:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblNganSach](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[danhMucID] [int] NULL,
	[nganSach] [int] NULL,
	[userId] [int] NULL,
	[ThangNam] [varchar](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 1/5/2024 3:29:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](255) NOT NULL,
	[password] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[tblChiTieu] ON 

INSERT [dbo].[tblChiTieu] ([id], [ngay], [danhMucID], [tien], [userID]) VALUES (2, CAST(N'2023-12-01' AS Date), 1, CAST(50000.00 AS Decimal(18, 2)), 1)
INSERT [dbo].[tblChiTieu] ([id], [ngay], [danhMucID], [tien], [userID]) VALUES (5, CAST(N'2023-12-01' AS Date), 7, CAST(5000000.00 AS Decimal(18, 2)), 1)
INSERT [dbo].[tblChiTieu] ([id], [ngay], [danhMucID], [tien], [userID]) VALUES (7, CAST(N'2023-12-12' AS Date), 1, CAST(2200000.00 AS Decimal(18, 2)), 5)
INSERT [dbo].[tblChiTieu] ([id], [ngay], [danhMucID], [tien], [userID]) VALUES (8, CAST(N'2023-12-20' AS Date), 2, CAST(1000000.00 AS Decimal(18, 2)), 5)
INSERT [dbo].[tblChiTieu] ([id], [ngay], [danhMucID], [tien], [userID]) VALUES (9, CAST(N'2023-12-21' AS Date), 7, CAST(3000000.00 AS Decimal(18, 2)), 5)
INSERT [dbo].[tblChiTieu] ([id], [ngay], [danhMucID], [tien], [userID]) VALUES (10, CAST(N'2023-12-20' AS Date), 1, CAST(50000.00 AS Decimal(18, 2)), 6)
INSERT [dbo].[tblChiTieu] ([id], [ngay], [danhMucID], [tien], [userID]) VALUES (11, CAST(N'2023-11-15' AS Date), 2, CAST(2000000.00 AS Decimal(18, 2)), 6)
INSERT [dbo].[tblChiTieu] ([id], [ngay], [danhMucID], [tien], [userID]) VALUES (12, CAST(N'2023-12-01' AS Date), 7, CAST(5000000.00 AS Decimal(18, 2)), 6)
INSERT [dbo].[tblChiTieu] ([id], [ngay], [danhMucID], [tien], [userID]) VALUES (14, CAST(N'2023-11-15' AS Date), 3, CAST(400000.00 AS Decimal(18, 2)), 1)
INSERT [dbo].[tblChiTieu] ([id], [ngay], [danhMucID], [tien], [userID]) VALUES (15, CAST(N'2022-08-18' AS Date), 5, CAST(2000000.00 AS Decimal(18, 2)), 1)
SET IDENTITY_INSERT [dbo].[tblChiTieu] OFF
GO
INSERT [dbo].[tblDanhMuc] ([id], [danhMuc]) VALUES (1, N'Ăn uống')
INSERT [dbo].[tblDanhMuc] ([id], [danhMuc]) VALUES (2, N'Nhà ở, điện nước')
INSERT [dbo].[tblDanhMuc] ([id], [danhMuc]) VALUES (3, N'Mua sắm')
INSERT [dbo].[tblDanhMuc] ([id], [danhMuc]) VALUES (4, N'Quà tặng')
INSERT [dbo].[tblDanhMuc] ([id], [danhMuc]) VALUES (5, N'Y tế')
INSERT [dbo].[tblDanhMuc] ([id], [danhMuc]) VALUES (6, N'Giáo dục')
INSERT [dbo].[tblDanhMuc] ([id], [danhMuc]) VALUES (7, N'Lương (thu)')
INSERT [dbo].[tblDanhMuc] ([id], [danhMuc]) VALUES (8, N'Tiền chuyển đến (thu)')
INSERT [dbo].[tblDanhMuc] ([id], [danhMuc]) VALUES (9, N'Khoản thu khác')
GO
SET IDENTITY_INSERT [dbo].[tblNganSach] ON 

INSERT [dbo].[tblNganSach] ([id], [danhMucID], [nganSach], [userId], [ThangNam]) VALUES (2, 1, 2000000, 1, N'2023-11')
INSERT [dbo].[tblNganSach] ([id], [danhMucID], [nganSach], [userId], [ThangNam]) VALUES (7, 6, 500000, 1, N'2022-12')
INSERT [dbo].[tblNganSach] ([id], [danhMucID], [nganSach], [userId], [ThangNam]) VALUES (8, 3, 500000, 1, N'2023-11')
INSERT [dbo].[tblNganSach] ([id], [danhMucID], [nganSach], [userId], [ThangNam]) VALUES (9, 1, 3000000, 1, N'2023-12')
SET IDENTITY_INSERT [dbo].[tblNganSach] OFF
GO
SET IDENTITY_INSERT [dbo].[tblUser] ON 

INSERT [dbo].[tblUser] ([id], [username], [password]) VALUES (1, N'admin', N'admin')
INSERT [dbo].[tblUser] ([id], [username], [password]) VALUES (2, N'test', N'test')
INSERT [dbo].[tblUser] ([id], [username], [password]) VALUES (3, N'a', N'a')
INSERT [dbo].[tblUser] ([id], [username], [password]) VALUES (4, N'chuong', N'chuong')
INSERT [dbo].[tblUser] ([id], [username], [password]) VALUES (5, N'abc', N'abc')
INSERT [dbo].[tblUser] ([id], [username], [password]) VALUES (6, N'123', N'123')
INSERT [dbo].[tblUser] ([id], [username], [password]) VALUES (7, N'v', N'v')
SET IDENTITY_INSERT [dbo].[tblUser] OFF
GO
ALTER TABLE [dbo].[tblChiTieu]  WITH CHECK ADD FOREIGN KEY([danhMucID])
REFERENCES [dbo].[tblDanhMuc] ([id])
GO
ALTER TABLE [dbo].[tblChiTieu]  WITH CHECK ADD FOREIGN KEY([userID])
REFERENCES [dbo].[tblUser] ([id])
GO
ALTER TABLE [dbo].[tblNganSach]  WITH CHECK ADD FOREIGN KEY([danhMucID])
REFERENCES [dbo].[tblDanhMuc] ([id])
GO
ALTER TABLE [dbo].[tblNganSach]  WITH CHECK ADD  CONSTRAINT [fk_tblNganSach_tblUser] FOREIGN KEY([userId])
REFERENCES [dbo].[tblUser] ([id])
GO
ALTER TABLE [dbo].[tblNganSach] CHECK CONSTRAINT [fk_tblNganSach_tblUser]
GO
USE [master]
GO
ALTER DATABASE [quanlychitieu] SET  READ_WRITE 
GO
