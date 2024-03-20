
import sys
import csv
import json
import xml.etree.ElementTree as ET

def read_file(filename, encodings=['utf-8', 'ISO-8859-1']):
    for encoding in encodings:
        try:
            with open(filename, 'r', encoding=encoding) as file:
                return file.readlines()
        except UnicodeDecodeError:
            pass
    raise UnicodeDecodeError(f"Unable to decode file {filename}")

def convert_to_csv(data, output_file):
    with open(output_file, 'w', newline='') as file:
        writer = csv.writer(file)
        for line in data:
            writer.writerow(line.strip().split('\t'))

def convert_to_json(data, output_file):
    with open(output_file, 'w') as file:
        json.dump(data, file)

def convert_to_xml(data, output_file):
    root = ET.Element('data')
    for line in data:
        row = ET.SubElement(root, 'row')
        row.text = line.strip()
    tree = ET.ElementTree(root)
    tree.write(output_file)

if __name__ == '__main__':
    if len(sys.argv) != 4:
        print("Usage: python convert_format.py <filename> <format> <output_filename>")
        sys.exit(1)

    filename = sys.argv[1]
    output_format = sys.argv[2]
    output_file = sys.argv[3]

    data = read_file(filename)

    if output_format == '-c':
        convert_to_csv(data, output_file + '.csv')
    elif output_format == '-j':
        convert_to_json(data, output_file + '.json')
    elif output_format == '-x':
        convert_to_xml(data, output_file + '.xml')
    else:
        print("Invalid output format. Use '-c' for CSV, '-j' for JSON, or '-x' for XML.")
