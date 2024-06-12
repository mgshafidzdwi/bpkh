# bpkh

# run docker-compose for postgres:
# docker-compose up

# query sql:
# CREATE DATABASE bpkhu_db;
# 
# -- Create table penumpang
# CREATE TABLE penumpang (
#     id_penumpang SERIAL PRIMARY KEY,
#     nama VARCHAR(255),
#     no_telp VARCHAR(50)
# );
# 
# -- Create table travel
# CREATE TABLE travel (
#     id SERIAL PRIMARY KEY,
#     nama_travel VARCHAR(255),
#     no_telp VARCHAR(50),
#     alamat VARCHAR(255),
#     no_polisi VARCHAR(50),
#     jenis_bus VARCHAR(50)
# );
# 
# -- Create table tiket
# CREATE TABLE tiket (
#     id SERIAL PRIMARY KEY,
#     id_penumpang INTEGER NOT NULL,
#     id_travel INTEGER NOT NULL,
#     jadwal TIMESTAMP NOT NULL,
#     FOREIGN KEY (id_penumpang) REFERENCES penumpang(id_penumpang),
#     FOREIGN KEY (id_travel) REFERENCES travel(id)
# );
# 
# -- Insert data into penumpang table
# INSERT INTO penumpang (nama, no_telp) VALUES
# ('Lukman', '0812341234213'),
# ('Akbar', '0918234283343'),
# ('Dewa Ngoman', '0900924483343');
# 
# -- Insert data into travel table
# INSERT INTO travel (nama_travel, no_telp, alamat, no_polisi, jenis_bus) VALUES
# ('Baraya Travel - 001', '0813284343433', 'Jl.Cisaranten, Bandung', 'D 2524 ZZC', '15 Seater'),
# ('Daytrans - 102', '0918234483343', 'Jl. Melawai, Jakarta', 'B 4343 KDF', '24 Seater'),
# ('Lintas Shuttle - 203', '0900934483343', 'Jl. Panglima Polim, Jakarta', 'B 2343 DKJ', '11 Seater'),
# ('Baraya Travel - 005', '0813284343133', 'Jl. Sulanjana, Bandung', 'D 171 TAK', '13 Seater'),
# ('Daytrans – 1-05', '0918234283343', 'Jl. Pela Mampang, Jakarta', 'B 413 IKU', '13 Seater'),
# ('Daytrans – 1-06', '0918334283343', 'Jl.Daan Mogot, Jakarta', 'B 333 IKT', '15 Seater');
# 
# -- Insert data into tiket table
# INSERT INTO tiket (id_penumpang, id_travel, jadwal) VALUES
# (1, 1, '2017-10-20 10:00'),
# (2, 3, '2017-10-20 10:00'),
# (3, 2, '2017-10-20 10:00');
