CREATE DATABASE IF NOT EXISTS ecoplantmatchDB;

USE ecoplantmatchDB;

CREATE TABLE tanaman (
id_tanaman INT AUTO_INCREMENT PRIMARY KEY,
kode_tanaman VARCHAR(30) NOT NULL,
nama_tanaman VARCHAR(30) NOT NULL,
keterangan TEXT DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO tanaman (kode_tanaman, nama_tanaman, keterangan) VALUES
('B0001','Jeruk', 'Tanaman jeruk cocok ditanam hampir semua jenis tanah kecuali kapur, tanaman jeruk juga membutuhkan cahaya matahari yang cukup dan cocok di tanam di daerah dengan curah hujan yang cukup rendah. 
Tanaman jeruk direkomendasikan ditanam di ketinggian tanah 700-1000 mdpl dan membutuhkan suhu yang dingin agar bisa tumbuh dengan baik'),
('B0002', 'Stroberi', 'Tanaman stroberi cocok ditanam hampir semua jenis tanaman kecuali tanah berjenis kapur, tanaman stroberi membutuhkan cahaya matahari yang cukup, dan cocok di tempat dengan curah hujan yang tinggi.
 Tanaman stroberi direkomendasikan ditanam di ketinggian 1000-1500 mdpl dan membutuhkan suhu yang dingin'),
('B0003', 'Tomat', 'Tanaman tomat cocok hampir di semua jenis tanah kecuali di tanah jenis kapur, tanaman tomat membutuhkan cahaya matahari yang cukup dan cocok di daerah dengan curah hujan yang cukup rendah.
Tanaman tomat direkomendasikan ditanam di ketinggian 600 - 700 mdpl dan membutuhkan suhu yang cukup dingin'),
('B0004', 'Cabe','Tanaman cabe cocok hampir di semua jenis tanah kecuali di tanah berjenis kapur, tanaman cabe membutuhkan cahaya matahari yang cukup dan cocok di daerah dengan curah hujan yang rendah.
Tanaman cabe direkomendasikan ditanam di ketinggian 600 - 700 mdpl dan membutuhkan suhu yang cukup dingin'),
('B0005', 'Apel', 'Tanaman apel cocok hampir di semua jenis tanah kecuali di tanah berjenis kapur, tanaman apel membutuhkan cahaya matahari yang cukup dan cocok di daerah dengan curah hujan yang rendah.
Tanaman apel direkomendasikan ditanam di ketinggian 1000 - 1500 mdpl dan membutuhkan suhu yang cukup dingin'),
('B0006', 'Markisa', 'Tanaman  markisa cocok ditanam hampir semua jeis tanah kecuali tanah berjenis kapur, tanaman markisa membutuhkan cahaya matahari yang cukup dan cocok di daerah dengan curah hujan yang rendah.
Tanaman apel direkomendasikan ditanam di ketinggian 600 - 700 mdpl dan membutuhkan suhu yang cukup dingin'),
('B0007', 'Lemon', 'Tanaman lemon cocok ditanam hampir semua jenis tanah kecuali tanah jenis kapur, tanaman lemon membutuhkan cahaya matahari yang cukup dan cocok di daerah dengan curah hujan yang tinggi.
Tanaman lemon direkomendasikan ditanam di ketinggian 700 - 1000 mdpl dan membutuhkan suhu yang cukup dingin'),
('B0008', 'Aprikot', 'Tanaman aprikot cocok ditanam hampir semua jenis tanah kecuali tanah jenis kapur, tanaman aprikot membutuhkan cahaya matahari yang cukup dan cocok di daerah dengan curah hujan yang tinggi.
Tanaman aprikot direkomendasikan ditanam di ketinggian 700 - 1000 mdpl dan membutuhkan suhu yang cukup dingin' ),
('B0009', 'Raspberry', 'Tanaman rapsberry cocok ditanam hampir di semua jenis tanah kecuali tanah jenis kapur, tanaman rapsbery membutuhkan cahaya matahari yang cukup dan cocok di daerah dengan curah hujan yang tinggi.
Tanaman rapsberry direkomendasikan ditanam di ketinggian 1000 - 1500 mdpl dan membuthkan suhu yang cukup dingin'),
('B0010', 'Timun' ,'Tanaman timun cocok ditanam hampir di semua jenis tanah kecuali tanah jenis kapur, tanaman timun sangat membutuhkan cahaya matahari dan cocok di daerah dengan curah hujan yang rendah.
Tanaman timun direkomendasikan ditanam di ketinggian 700 - 1000 mdpl dan membutuhkan suhu yang cukup dingin');

CREATE TABLE jenis_tanah (
id_tanah INT AUTO_INCREMENT PRIMARY KEY,
kode_tanah VARCHAR(10) NOT NULL,
nama_tanah VARCHAR(20) NOT NULL,
keterangan_tanah TEXT DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO jenis_tanah (kode_tanah, nama_tanah, keterangan_tanah) VALUES
('T0001', 'latosol', 'Tanah latosol adalah warnanya yang merah hingga kuning, teksturnya lempung dan memiliki solum horizon'),
('T0002', 'kapur', 'Tanah berjenis kapur Berbeda dengan jenis tanah lain yang berwarna cokelat, tanah kapur justru berwarna putih atau lebih terang'),
('T0003', 'humus', 'Tanah humus berwarna cokelat gelap hingga hitam pekat, yang disebabkan oleh kandungan bahan organik yang tinggi'),
('T0004', 'grumusol', 'Tanah grumusol tekstur tanahnya kering dan mudah pecah terutama saat musim kemarau dan memiliki warna hitam'),
('T0005', 'entisol', 'Tanah entisol merupakan jenis tanah yang masih sangat muda dimana jenis tanah ini belum membentuk horison'),
('T0006', 'andosol', 'Tanah andosol merupakan salah satu jenis tanah vulkanik dimana terbentuk karena adanya proses vulkanisme pada gunung berapi, jenis tanah ini umumnya berwarna hitam'),
('T0007', 'aluvial', 'Tanah  aluvial merupakan jenis tanah yang terjadi karena endapan lumpur biasanya yang terbawa karena aliran sungai, biasanya berwarna cokelat hingga kelabu');

CREATE TABLE jenis_suhu (
Id_suhu INT AUTO_INCREMENT PRIMARY KEY,
kode_suhu VARCHAR(20) NOT NULL,
jenis_suhu VARCHAR(10) NOT NULL,
keterangan TEXT DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO jenis_suhu( kode_suhu, jenis_suhu, keterangan) VALUES
('S0001', 'Dingin', 'Suhu dingin secara umum berkisar antara 15°C - 22°C'),
('S0002', 'Panas', 'Suhu panas secara umun berkisar antara 34,5°C – 38,4°C');

CREATE TABLE cahaya (
id_cahaya INT AUTO_INCREMENT PRIMARY KEY,
kode_cahaya VARCHAR(20),
jenis_cahaya VARCHAR(50) NOT NULL,
keterangan TEXT DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO cahaya( kode_cahaya, jenis_cahaya, keterangan) VALUES
('C0001', 'Terkena cahaya dengan sempurna', 'Terkena pencahayaan dari matahari dengan baik'),
('C0002', 'Cahaya sedikit terhalang', 'Terkena pencahayaan dari matahari tetapi terhalang oleh benda lain'),
('C0003', 'Cahaya sangat terhalang', 'Tidak terkena pencahayaan sama sekali dari matahari');

CREATE TABLE curah_hujan(
id_curah_hujan INT AUTO_INCREMENT PRIMARY KEY,
kode_curah_hujan VARCHAR(20) NOT NULL,
jenis_curah_hujan VARCHAR(50) NOT NULL,
keterangan TEXT DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO curah_hujan(kode_curah_hujan, jenis_curah_hujan, keterangan) VALUES
('H0001', 'Tinggi', 'Tinggi (300 – 500 mm)'),
('H0002', 'Sedang', 'Sedang ( 100 – 300 mm)'),
('H0003', 'Rendah', 'Rendah ( < 200 mm)');

CREATE TABLE ketinggian_tanah(
id_ketinggian_tanah INT AUTO_INCREMENT PRIMARY KEY,
kode_ketinggian VARCHAR(20) NOT NULL,
jenis_ketinggian_tanah VARCHAR(50) NOT NULL,
keterangan TEXT DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO ketinggian_tanah(kode_ketinggian, jenis_ketinggian_tanah, keterangan) VALUES
('K0001', 'Tinggi', 'Tinggi (1000-1500mdpl)'),
('K0002', 'Sedang', 'Sedang (700-1000mdpl)'),
('K0003', 'Rendah', 'Rendah (1000-1500mdpl)');

CREATE TABLE relasi_jenis_tanah (
  kode_tanaman VARCHAR(50) NOT NULL,
  kode_tanah VARCHAR(50) NOT NULL,
  nilai FLOAT NOT NULL
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;
  
  INSERT INTO relasi_jenis_tanah(kode_tanaman, kode_tanah, nilai) VALUES
  ('B0001', 'T0001', 0.8),
  ('B0002', 'T0001', 0.8),
  ('B0003', 'T0001', 0.8),
  ('B0004', 'T0001', 0.8),
  ('B0005', 'T0001', 0.8),
  ('B0006', 'T0001', 0.8),
  ('B0007', 'T0001', 0.8),
  ('B0008', 'T0001', 0.8),
  ('B0009', 'T0001', 0.8),
  ('B0010', 'T0001', 0.8),
  ('B0001','T0002', 0.2),
  ('B0002','T0002', 0.2),
  ('B0003','T0002', 0.2),
  ('B0004','T0002', 0.2),
  ('B0005','T0002', 0.2),
  ('B0006','T0002', 0.2),
  ('B0007','T0002', 0.2),
  ('B0008','T0002', 0.2),
  ('B0009','T0002', 0.2),
  ('B0010','T0002', 0.2),
  ('B0001','T0003',0.8),
  ('B0002','T0003',0.8),
  ('B0003','T0003',0.8),
  ('B0004','T0003',0.8),
  ('B0005','T0003',0.8),
  ('B0006','T0003',0.8),
  ('B0007','T0003',0.8),
  ('B0008','T0003',0.8),
  ('B0009','T0003',0.8),
  ('B0010','T0003',0.8),
  ('B0001','T0004',0.8),
  ('B0002','T0004',0.8),
  ('B0003','T0004',0.8),
  ('B0004','T0004',0.8),
  ('B0005','T0004',0.8),
  ('B0006','T0004',0.8),
  ('B0007','T0004',0.8),
  ('B0008','T0004',0.8),
  ('B0009','T0004',0.8),
  ('B0010','T0004',0.8),
  ('B0001','T0005',0.8),
  ('B0002','T0005',0.8),
  ('B0003','T0005',0.8),
  ('B0004','T0005',0.8),
  ('B0005','T0005',0.8),
  ('B0006','T0005',0.8),
  ('B0007','T0005',0.8),
  ('B0008','T0005',0.8),
  ('B0009','T0005',0.8),
  ('B0010','T0005',0.8),
  ('B0001','T0006',0.75),
  ('B0002','T0006',0.75),
  ('B0003','T0006',0.75),
  ('B0004','T0006',0.75),
  ('B0005','T0006',0.75),
  ('B0006','T0006',0.75),
  ('B0007','T0006',0.75),
  ('B0008','T0006',0.75),
  ('B0009','T0006',0.75),
  ('B0010','T0006',0.75),
  ('B0001','T0007',0.7),
  ('B0002','T0007',0.7),
  ('B0003','T0007',0.7),
  ('B0004','T0007',0.7),
  ('B0005','T0007',0.7),
  ('B0006','T0007',0.7),
  ('B0007','T0007',0.7),
  ('B0008','T0007',0.7),
  ('B0009','T0007',0.7),
  ('B00010','T0007',0.7);

CREATE TABLE relasi_jenis_suhu (
  kode_tanaman VARCHAR(25) NOT NULL,
  kode_suhu VARCHAR(25) NOT NULL,
  nilai FLOAT NOT NULL
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;
  
  INSERT INTO relasi_jenis_suhu(kode_tanaman, kode_suhu, nilai) VALUES
  ('B0001','S0001',0.75),
  ('B0002','S0001',0.85),
  ('B0003','S0001',0.75),
  ('B0004','S0001',0.7),
  ('B0005','S0001',0.75),
  ('B0006','S0001',0.7),
  ('B0007','S0001',0.75),
  ('B0008','S0001',0.7),
  ('B0009','S0001',0.75),
  ('B0010','S0001',0.75),
  ('B0001','S0002',0.1),
  ('B0002','S0002',0.1),
  ('B0003','S0002',0.1),
  ('B0004','S0002',0.1),
  ('B0005','S0002',0.1),
  ('B0006','S0002',0.1),
  ('B0007','S0002',0.1),
  ('B0008','S0002',0.1),
  ('B0009','S0002',0.1),
  ('B0010','S0002',0.1);


CREATE TABLE relasi_jenis_cahaya (
  kode_tanaman VARCHAR(25) NOT NULL,
  kode_cahaya VARCHAR(25) NOT NULL,
  nilai FLOAT NOT NULL
  ); 
  
  INSERT INTO relasi_jenis_cahaya(kode_tanaman, kode_cahaya, nilai) VALUES
  ('B0001','C0001',0.2),
  ('B0002','C0001',0.1),
  ('B0003','C0001',0.3),
  ('B0004','C0001',0.1),
  ('B0005','C0001',0.3),
  ('B0006','C0001',0.25),
  ('B0007','C0001',0.1),
  ('B0008','C0001',0.1),
  ('B0009','C0001',0.1),
  ('B0010','C0001',0.6),
  ('B0001','C0002',0.7),
  ('B0002','C0002',0.85),
  ('B0003','C0002',0.65),
  ('B0004','C0002',0.85),
  ('B0005','C0002',0.7),
  ('B0006','C0002',0.7),
  ('B0007','C0002',0.7),
  ('B0008','C0002',0.85),
  ('B0009','C0002',0.7),
  ('B0010','C0002',0.35),
  ('B0001','C0003',0.1),
  ('B0002','C0003',0.1),
  ('B0003','C0003',0.1),
  ('B0004','C0003',0.1),
  ('B0005','C0003',0.3),
  ('B0006','C0003',0.1),
  ('B0007','C0003',0.25),
  ('B0008','C0003',0.1),
  ('B0009','C0003',0.2),
  ('B0010','C0003',0.1);

CREATE TABLE relasi_ketinggian_tanah (
kode_tanaman VARCHAR(25) NOT NULL,
kode_ketinggian VARCHAR(25) NOT NULL,
nilai FLOAT NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO relasi_ketinggian_tanah (kode_tanaman, kode_ketinggian, nilai) VALUES
  ('B0001','K0001',0.65),
  ('B0002','K0001',0.1),
  ('B0003','K0001',0.75),
  ('B0004','K0001',0.75),
  ('B0005','K0001',0.75),
  ('B0006','K0001',0.7),
  ('B0007','K0001',0.8),
  ('B0008','K0001',0.6),
  ('B0009','K0001',0.6),
  ('B00010','K0001',0.1),
  ('B0001','K0002',0.8),
  ('B0002','K0002',0.1),
  ('B0003','K0002',0.1),
  ('B0004','K0002',0.1),
  ('B0005','K0002',0.1),
  ('B0006','K0002',0.25),
  ('B0007','K0002',0.85),
  ('B0008','K0002',0.85),
  ('B0009','K0002',0.1),
  ('B0010','K0002',0.8),
  ('B0001','K0003',0.1),
  ('B0002','K0003',0.9),
  ('B0003','K0003',0.1),
  ('B0004','K0003',0.1),
  ('B0005','K0003',0.85),
  ('B0006','K0003',0.1),
  ('B0007','K0003',0.1),
  ('B0008','K0003',0.1),
  ('B0009','K0003',0.85),
  ('B0010','K0003',0.1);

CREATE TABLE relasi_curah_hujan(
kode_tanaman VARCHAR(25) NOT NULL,
kode_curah_hujan VARCHAR (25) NOT NULL,
nilai FLOAT NOT NULL
);

INSERT INTO relasi_curah_hujan(kode_tanaman, kode_curah_hujan, nilai) VALUES
  ('B0001','H0001',0.1),
  ('B0002','H0001',0.7),
  ('B0003','H0001',0.1),
  ('B0004','H0001',0.1),
  ('B0005','H0001',0.7),
  ('B0006','H0001',0.1),
  ('B0007','H0001',0.6),
  ('B0008','H0001',0.6),
  ('B0009','H0001',0.7),
  ('B00010','H0001',0.1),
  ('B0001','H0002',0.65),
  ('B0002','H0002',0.3),
  ('B0003','H0002',0.4),
  ('B0004','H0002',0.4),
  ('B0005','K0002',0.3),
  ('B0006','H0002',0.4),
  ('B0007','H0002',0.4),
  ('B0008','H0002',0.4),
  ('B0009','H0002',0.3),
  ('B0010','H0002',0.3),
  ('B0001','K0003',0.35),
  ('B0002','K0003',0.1),
  ('B0003','K0003',0.6),
  ('B0004','K0003',0.6),
  ('B0005','K0003',0.1),
  ('B0006','K0003',0.6),
  ('B0007','K0003',0.1),
  ('B0008','K0003',0.1),
  ('B0009','K0003',0.1),
  ('B0010','K0003',0.7);
